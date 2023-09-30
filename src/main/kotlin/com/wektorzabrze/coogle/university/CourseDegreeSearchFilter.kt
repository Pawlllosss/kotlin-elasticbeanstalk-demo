package com.wektorzabrze.coogle.university

interface CourseDegreeSearchFilter {
    fun filter(universities: Collection<CourseDegree>, parameter: Parameter): Collection<CourseDegree>
    fun shouldHandle(parameter: Parameter): Boolean
}