package com.wektorzabrze.coogle.university.filters.university

import com.wektorzabrze.coogle.university.Parameter
import com.wektorzabrze.coogle.university.University
import com.wektorzabrze.coogle.university.UniversityType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class UniversityCityFilterTest{
    @Test
    fun `should filter only universities in Kraków`() {
        val result = UniversityCityFilter(jacksonObjectMapper()).filter(
            listOf(
                University(listOf(), city="Kraków"),
                University(listOf(), city="Wrocław"),
                University(listOf(), city="Kraków"),
            ),
            parameter = Parameter("universityCity", """["Kraków"]""")
        )

        assertEquals(2, result.size)
    }

    @Test
    fun `should filter only universities in Kraków and Wrocław`() {
        val result = UniversityCityFilter(jacksonObjectMapper()).filter(
            listOf(
                University(listOf(), city="Kraków"),
                University(listOf(), city="Wrocław"),
                University(listOf(), city="Kraków"),
            ),
            parameter = Parameter("universityCity", """["Kraków", "Wrocław"]""")
        )

        assertEquals(3, result.size)
    }

    @Test
    fun `should filter all universities`() {
        val result = UniversityCityFilter(jacksonObjectMapper()).filter(
            listOf(
                University(listOf(), city="Kraków"),
                University(listOf(), city="Wrocław"),
                University(listOf(), city="Kraków"),
                University(listOf(), city="Zbąszynek"),
            ),
            parameter = Parameter("universityCity", """[]""")
        )

        assertEquals(4, result.size)
    }

    @Test
    fun `should filter non universities`() {
        val result = UniversityCityFilter(jacksonObjectMapper()).filter(
            listOf(
                University(listOf(), city="Kraków"),
                University(listOf(), city="Wrocław"),
                University(listOf(), city="Kraków"),
            ),
            parameter = Parameter("universityCity", """["Zbąszynek"]""")
        )

        assertEquals(0, result.size)
    }
}