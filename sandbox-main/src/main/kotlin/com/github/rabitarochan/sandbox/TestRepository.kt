package com.github.rabitarochan.sandbox

import com.github.rabitarochan.sandbox.kapt.SoraRepository
import com.github.rabitarochan.sandbox.kapt.TestAnnotation

data class Person(val name: String, val age: Int)

@TestAnnotation
interface TestRepository : SoraRepository<Person> {



}
