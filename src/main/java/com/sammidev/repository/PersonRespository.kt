package com.sammidev.repository

import com.sammidev.entity.Person

interface PersonRespository {
    fun selectById(id: Int): Person?
    fun selectAll(): List<Person>
    fun getByName(name: String): Person?
    fun insert(person: Person)
}
