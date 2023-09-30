package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.Parameter
import io.kotest.matchers.collections.shouldContainAll
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
            CourseDegree("Socjologia"),
            CourseDegree("Geoinformatyka"),
            CourseDegree("Nieinfa", "Informatyka dla niemców")
        )
        val parameter = Parameter("keyword", """["Informatyka"]""")

        //when
        val result = sut.filter(courseDegrees, parameter)

        //then
        result shouldContainAll listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Geoinformatyka"),
            CourseDegree("Socjologia"),
            CourseDegree("Nieinfa", "Informatyka dla niemców")
        )
    }

    @Test
    fun `should properly handle multiple value filter`() {
        //given
        val courseDegrees = listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Socjologia"),
            CourseDegree("Pielęgniarstwo"),
            CourseDegree("Chirurgia"),
            CourseDegree("Geoinformatyka"),
            CourseDegree("Nieinfa", "Informatyka dla niemców")
        )
        val parameter = Parameter("keyword", """["Informatyka", "socjologia"]""")

        //when
        val result = sut.filter(courseDegrees, parameter)

        //then
        result shouldContainAll listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Socjologia"),
            CourseDegree("Geoinformatyka"),
            CourseDegree("Nieinfa", "Informatyka dla niemców")
        )
    }

    @Test
    fun `should properly empty filter list`() {
        //given
        val courseDegrees = listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Socjologia")
        )
        val parameter = Parameter("keyword", """[]""")

        //when
        val result = sut.filter(courseDegrees, parameter)

        //then
        result shouldContainAll listOf(
            CourseDegree("Informatyka"),
            CourseDegree("Socjologia")
        )
    }

}