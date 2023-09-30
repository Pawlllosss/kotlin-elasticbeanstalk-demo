package com.wektorzabrze.coogle.university

import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import pl.oczadly.ebs.demo.entity.DemoEntity
import pl.oczadly.ebs.demo.repository.TestRepository
import pl.oczadly.ebs.demo.service.DemoService

class UniversityTypeFilterTest{

    @Test
    fun shouldGetPrivateUniversities() {
        val result = UniversityTypeFilter().filter(
            listOf(
                University(listOf(), UniversityType.PRIVATE),
                University(listOf(), UniversityType.PUBLIC),
                University(listOf(), UniversityType.PRIVATE),
            ),
            parameter = Parameter("universityType", "PRIVATE")
        )

        assertEquals(2, result.size)
    }

    @Test
    fun shouldGetPublicUniversities() {
        val result = UniversityTypeFilter().filter(
            listOf(
                University(listOf(), UniversityType.PRIVATE),
                University(listOf(), UniversityType.PUBLIC),
                University(listOf(), UniversityType.PRIVATE),
            ),
            parameter = Parameter("universityType", "PUBLIC")
        )
        assertEquals(1, result.size)
    }
}