package pl.oczadly.ebs.demo.service

import org.springframework.stereotype.Service
import pl.oczadly.ebs.demo.entity.DemoEntity

@Service
class DemoService {
    fun getDemoValue(): DemoEntity = DemoEntity("test")
}