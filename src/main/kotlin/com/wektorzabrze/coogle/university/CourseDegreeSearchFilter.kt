package com.wektorzabrze.coogle.university

interface CourseDegreeSearchFilter {
    fun filter(universities: Collection<CourseDegree>, value: String): Collection<CourseDegree>
    val discriminator: String
}