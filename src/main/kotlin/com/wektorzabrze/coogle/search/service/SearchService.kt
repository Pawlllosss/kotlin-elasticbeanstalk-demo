package com.wektorzabrze.coogle.search.service

import com.wektorzabrze.coogle.university.CourseDegreeSearchFilter
import com.wektorzabrze.coogle.university.University
import com.wektorzabrze.coogle.university.UniversitySearchFilter
import com.wektorzabrze.coogle.university.services.UniversityService
import org.springframework.stereotype.Service

@Service
class SearchService(
    universitySearchFilters: List<UniversitySearchFilter>,
    courseDegreeSearchFilters: List<CourseDegreeSearchFilter>,
    private val universityService: UniversityService
) {
    private val universitySearchFilterByDiscriminator: Map<String, UniversitySearchFilter> =
    universitySearchFilters.associateBy { it.discriminator() }
    private val courseDegreeSearchFilterByDiscriminator = courseDegreeSearchFilters.associateBy { it.discriminator() }
    
    fun search(searchParameters: Map<String, String>): Collection<University> {
        val universityFilterByFilterValue = getUniversityFiltersToApply(searchParameters)
        val courseDegreeFilterByFilterValue = getCourseDegreesFiltersToApply(searchParameters)

        val universities = universityService
        
        val filteredUniversities = courseDegreeFilterByFilterValue.entries.fold(universities) { filteredUniversities, searchFilterByValue ->
            searchFilterByValue.key.filter(filteredUniversities, searchFilterByValue.value)
        }
        
//        val universities = universityService.getUniversities()
//            .filter { university -> universityFilterByFilterValue.all { (searchFilter, value) -> 
//                searchFilter.filter()
//            } }
        
        
    }
    
    fun getUniversityFiltersToApply(searchParameters: Map<String, String>): Map<UniversitySearchFilter, String> = searchParameters
        .filter { universitySearchFilterByDiscriminator.containsKey(it.key) }
        .map { universitySearchFilterByDiscriminator[it.key]!! to it.value }
        .toMap()
    
    fun getCourseDegreesFiltersToApply(searchParameters: Map<String, String>): Map<CourseDegreeSearchFilter, String> = searchParameters
        .filter { courseDegreeSearchFilterByDiscriminator.containsKey(it.key) }
        .map { courseDegreeSearchFilterByDiscriminator[it.key]!! to it.value }
        .toMap()
}