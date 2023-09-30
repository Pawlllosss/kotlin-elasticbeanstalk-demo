package com.wektorzabrze.coogle.university.filters.coursedegree

import com.wektorzabrze.coogle.university.CourseDegree
import com.wektorzabrze.coogle.university.Parameter

interface CourseDegreeSearchFilter {
    fun filter(courseDegrees: Collection<CourseDegree>, parameter: Parameter): Collection<CourseDegree>
    val discriminator: String
}