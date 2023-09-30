package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.wektorzabrze.coogle.infrastructure.asList
import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.ExamThreshold
import com.wektorzabrze.coogle.university.GraduateExamThreshold
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class GraduationExamCourseDegreeFilter(val objectMapper: ObjectMapper) : CourseDegreeSearchFilter {

    override fun filter(courseDegrees: Collection<CourseDegree>, filterValue: String): Collection<CourseDegree> =
        courseDegrees
            .filter { courseDegree ->
                val examResults = mapFilterValue(filterValue)
                val intResult = examResults
                    .map { graduateExam -> (courseDegree.examThreshold.subjectToWeightMap.getOrDefault(graduateExam.subject.lowercase(), BigDecimal.ZERO).times(graduateExam.result))}
                    .reduce { acc, next -> acc + next }.toInt()
                intResult >= courseDegree.examThreshold.minThreshold.toInt()
            }
    override val discriminator: String
        get() = "graduationExamResults"

    private fun mapFilterValue(filterValue: String): List<GraduateExamThreshold> =
        objectMapper.asList(filterValue, GraduateExamThreshold::class.java)
}


