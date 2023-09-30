package com.wektorzabrze.coogle.university

interface UniversitySearchFilter {
    fun filter(universities: Collection<University>, parameter: Parameter): Collection<University>
    val discriminator: String
}