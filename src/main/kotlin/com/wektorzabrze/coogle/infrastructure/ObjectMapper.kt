package com.wektorzabrze.coogle.infrastructure

import com.fasterxml.jackson.databind.ObjectMapper

fun <T> ObjectMapper.asList(value: String, clazz: Class<T>):List<T> = this.readValue<T>(value, this.typeFactory.constructCollectionType(List::class.java, clazz)) as List<T>
