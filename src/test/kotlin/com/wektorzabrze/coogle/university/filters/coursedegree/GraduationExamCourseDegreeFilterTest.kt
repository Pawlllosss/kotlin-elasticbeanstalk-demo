package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.ExamThreshold
import io.kotest.matchers.collections.shouldContainAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class GraduationExamCourseDegreeFilterTest {
    @Test
    fun `should filter based on exam results`() {
        val courseDegrees = listOf(
            CourseDegree(
                name = "aaa", examThreshold = ExamThreshold(
                    subjectToWeightMap = mapOf(
                        "mat" to BigDecimal.valueOf(0.8),
                        "ang" to BigDecimal.valueOf(0.2)
                    ),
                    minThreshold = BigDecimal.valueOf(90)
                )
            )
        )
        val result = GraduationExamCourseDegreeFilter(jacksonObjectMapper()).filter(
            courseDegrees, """
        [
        {"subject":"mat", "result":"100.0"},
        {"subject":"ang", "result":"90.0"}
        ]
    """.trimIndent()
        )

        result shouldContainAll courseDegrees
    }
}


