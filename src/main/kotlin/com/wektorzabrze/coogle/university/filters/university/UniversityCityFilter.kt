package com.wektorzabrze.coogle.university.filters.university

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.university.Parameter
import com.wektorzabrze.coogle.university.University
import com.wektorzabrze.coogle.university.UniversityType
import org.springframework.stereotype.Component

@Component
class UniversityCityFilter(val mapper: ObjectMapper): UniversitySearchFilter {
    override fun filter(universities: Collection<University>, parameter: Parameter): Collection<University> {
        val cities = mapper.readValue(parameter.value, object : TypeReference<List<String>>() {})
        if (cities.isEmpty()) {
            return universities
        }
        return universities.filter { uni -> uni.city in cities }
    }

    override val discriminator: String
        get() = "universityCity"

}