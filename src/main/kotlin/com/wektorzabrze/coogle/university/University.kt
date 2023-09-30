package com.wektorzabrze.coogle.university

data class University (val courseDegrees: Collection<CourseDegree>, val type: UniversityType = UniversityType.PUBLIC, val city: String = "", val coordinates: Coordinates = Coordinates(0.0, 0.0)) {
}
