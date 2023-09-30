package com.wektorzabrze.coogle.university

import org.springframework.stereotype.Component

@Component
class UniversityTypeFilter: UniversitySearchFilter {
    override fun filter(universities: Collection<University>, parameter: Parameter): Collection<University> =
        universities.filter { uni-> uni.type.equals(UniversityType.valueOf(parameter.value))}

    override val discriminator: String
        get() = "universityType"

}

