package com.wektorzabrze.coogle.university

data class CourseDegree(
    val name: String,
    val description: String = "",
    val interests: Collection<String> = emptyList()
)
