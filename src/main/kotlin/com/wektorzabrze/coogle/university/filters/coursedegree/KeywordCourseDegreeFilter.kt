package com.wektorzabrze.coogle.university.filters.coursedegree

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.infrastructure.swagger.asList
import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.CourseDegreeSearchFilter
import com.wektorzabrze.coogle.university.Parameter
import org.springframework.stereotype.Component

@Component
class KeywordCourseDegreeFilter(val objectMapper: ObjectMapper) : CourseDegreeSearchFilter {

    override fun filter(courseDegrees: Collection<CourseDegree>, parameter: Parameter): Collection<CourseDegree> =
        courseDegrees
            .filter { courseDegree ->
                mapParameter(parameter).any {
                    courseDegree.name.uppercase().contains(it.uppercase()) || courseDegree.description.uppercase().contains(it.uppercase())
                }
            }

    override val discriminator: String
        get() = "keyword"

    private fun mapParameter(parameter: Parameter): List<String> =
        objectMapper.asList(parameter.value, String::class.java)
}