package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.Parameter
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class KeywordCourseDegreeFilterTest {

    private val sut = KeywordCourseDegreeFilter(ObjectMapper())

    @Test
    fun `should properly handle empty course list`() {
        //given
        val courseDegrees = emptyList<CourseDegree>()
        val parameter = Parameter("keyword", "Informatyka")

        //when
        val result = sut.filter(courseDegrees, parameter)

        //then
        result shouldBe emptyList()
    }


    @Test
    fun `should properly handle single value filter`() {
        //given
        val courseDegrees = listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Socjologia")
        )
        val parameter = Parameter("keyword", """["Informatyka"]""")

        //when
        val result = sut.filter(courseDegrees, parameter)

        //then
        result shouldHaveSingleElement CourseDegree("Informatyka")
    }

}