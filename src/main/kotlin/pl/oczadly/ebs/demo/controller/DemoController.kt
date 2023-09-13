package pl.oczadly.ebs.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import pl.oczadly.ebs.demo.entity.DemoEntity
import pl.oczadly.ebs.demo.service.DemoService

@RestController
class DemoController(private val service: DemoService) {

    @GetMapping("/demos")
    fun getDemos(): List<DemoEntity> = listOf(service.getDemoValue())

    @GetMapping("/demos2")
    fun getDemos2(): String = "new-demo-2"
}