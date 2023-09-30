package com.wektorzabrze.coogle.university

import java.util.UUID

data class University(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "",
    val photoUrl: String = "",
    val courseDegrees: Collection<CourseDegree> = emptyList(),
    val type: UniversityType = UniversityType.PUBLIC,
    val address: Address = Address("", "", ""),
    val coordinates: Coordinates = Coordinates(0.0, 0.0),
    val amenities: Collection<Amenity> = emptyList(),
    val accessibilitiesForDisabled: Collection<String> = emptyList(),
    val clubs: Collection<Club> = emptyList(),
    var isFavourite: Boolean = false
)
