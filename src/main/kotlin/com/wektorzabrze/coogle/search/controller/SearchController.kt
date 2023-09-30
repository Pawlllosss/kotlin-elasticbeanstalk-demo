package com.wektorzabrze.coogle.search.controller

import com.wektorzabrze.coogle.search.service.SearchService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchController(private val service: SearchService) {

    @PostMapping("/universities")
    fun searchUniversities(@RequestBody searchParameters: Map<String, String>) {
        
        
        service.search()
    }
}