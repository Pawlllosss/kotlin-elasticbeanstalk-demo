package com.wektorzabrze.coogle.university.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.wektorzabrze.coogle.infrastructure.asList
import com.wektorzabrze.coogle.university.University
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Service
import java.io.File

@Service
class UniversityService(objectMapper: ObjectMapper) {

    private lateinit var universities: Collection<University>
    init {
        universities = objectMapper.asList(getFileFromResources("mock-data.json"), University::class.java)
        println(universities)
    }

    fun getUniversities(): Collection<University> = universities.map { it.copy() }
}
private fun getFileFromResources(filename: String): File {
    val resource = ClassPathResource(filename)

    return resource.file
}