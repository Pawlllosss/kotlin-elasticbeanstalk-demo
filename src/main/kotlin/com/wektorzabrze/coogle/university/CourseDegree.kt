package com.wektorzabrze.coogle.university

data class CourseDegree(
    val name: String,
    val description: String = "",
    val level: String = "",
    val stationary: Boolean = true,
    val finalsSubjects: List<String> = emptyList(),
    val interests: Collection<String> = emptyList(),
    val occupations: Collection<String> = emptyList()
)
