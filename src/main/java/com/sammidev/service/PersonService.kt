package com.sammidev.service

import com.sammidev.entity.Person
import com.sammidev.repository.PersonRespository
import java.util.*

class PersonService(private val personRespository: PersonRespository) {

    fun get(id: String): Person {
        if (id.isBlank()) {
            throw IllegalArgumentException("person id is not valid")
        }

        val person = personRespository.selectById(id.toInt())
        if (person != null) return person
        else throw Exception("person not null")
    }

    fun getAll(): List<Person> = personRespository.selectAll()
    fun getPersonByName(name: String): Person {
        if (name.isBlank()){
            throw IllegalArgumentException("person id is not valid")
        }
        val personByName = personRespository.getByName(name)
        if (personByName != null) return personByName
        else throw Exception("person with $name not found")
    }


     fun register(name: String, nim: String): Person {
        val person = Person(UUID.randomUUID().toString().toInt(), name, nim)
        personRespository.insert(person)
        return person
     }


}