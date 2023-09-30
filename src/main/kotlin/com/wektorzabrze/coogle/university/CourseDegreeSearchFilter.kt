package com.wektorzabrze.coogle.university

interface CourseDegreeSearchFilter {
    fun filter(courseDegrees: Collection<CourseDegree>, parameter: Parameter): Collection<CourseDegree>
    val discriminator: String
}