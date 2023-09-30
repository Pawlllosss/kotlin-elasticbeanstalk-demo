package com.wektorzabrze.coogle.university

data class CourseDegree(
    val name: String,
    val description: String = "",
    val finalsSubjects: List<String> = emptyList()
)
