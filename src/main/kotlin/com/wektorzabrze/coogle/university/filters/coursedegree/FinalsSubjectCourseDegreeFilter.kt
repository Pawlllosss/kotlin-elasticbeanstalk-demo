package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.infrastructure.swagger.asList
import com.wektorzabrze.coogle.university.CourseDegree
import org.springframework.stereotype.Component

@Component
class FinalsSubjectCourseDegreeFilter(val objectMapper: ObjectMapper) : CourseDegreeSearchFilter {

    override fun filter(courseDegrees: Collection<CourseDegree>, filterValue: String): Collection<CourseDegree> =
        courseDegrees
            .filter { courseDegree ->
                val finalsSubjects = mapFilterValue(filterValue)
                if (finalsSubjects.isEmpty()) true else finalsSubjects.any {
                    courseDegree.finalsSubjects.map { subject -> subject.uppercase() }.contains(it.uppercase())
                }
            }

    override val discriminator: String
        get() = "finalsSubject"

    private fun mapFilterValue(filterValue: String): List<String> =
        objectMapper.asList(filterValue, String::class.java)
}