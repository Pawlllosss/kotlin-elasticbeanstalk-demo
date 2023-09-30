package com.wektorzabrze.coogle.university.filters.university

import com.wektorzabrze.coogle.university.Parameter
import com.wektorzabrze.coogle.university.University

interface UniversitySearchFilter {
    fun filter(universities: Collection<University>, parameter: Parameter): Collection<University>
    val discriminator: String
}