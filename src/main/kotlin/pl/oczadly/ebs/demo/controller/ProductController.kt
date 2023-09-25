package pl.oczadly.ebs.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pl.oczadly.ebs.demo.entity.Product
import pl.oczadly.ebs.demo.service.ProductService

@RestController("/products")
class ProductController(private val service: ProductService) {

    @GetMapping
    fun getProducts(): List<Product> = service.getProducts()

    @PostMapping
    fun createProduct(@RequestParam name: String, @RequestParam price: Double): Product = service.createProduct(name, price)
}