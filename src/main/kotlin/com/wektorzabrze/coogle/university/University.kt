package com.wektorzabrze.coogle.university

data class University(
    val name: String = "",
    val photoUrl: String = "",
    val courseDegrees: Collection<CourseDegree>,
    val type: UniversityType = UniversityType.PUBLIC,
    val address: Address = Address("", "", ""),
    val coordinates: Coordinates = Coordinates(0.0, 0.0),
    val amenities: Collection<Amenity> = emptyList(),
    val accessibilitiesForDisabled: Collection<String> = emptyList(),
    val clubs: Collection<Club> = emptyList()
)
