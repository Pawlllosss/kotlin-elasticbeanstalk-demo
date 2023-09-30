package com.wektorzabrze.coogle.university.filters.university

import com.wektorzabrze.coogle.university.University
import com.wektorzabrze.coogle.university.UniversityType
import org.springframework.stereotype.Component

@Component
class UniversityTypeFilter: UniversitySearchFilter {
    override fun filter(universities: Collection<University>, value: String): Collection<University> =
        universities.filter { uni-> uni.type == UniversityType.valueOf(value) }

    override val discriminator: String
        get() = "universityType"

}

