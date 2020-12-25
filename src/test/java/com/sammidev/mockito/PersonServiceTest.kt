package com.sammidev.mockito

import com.sammidev.entity.Person
import com.sammidev.repository.PersonRespository
import com.sammidev.service.PersonService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(value = [MockitoExtension::class])
class PersonServiceTest {

    // Mock -> otomatis bikin mock
    @Mock
    lateinit var personRepository: PersonRespository

    lateinit var personService: PersonService

    @BeforeEach
    fun before() {
        personService = PersonService(personRepository)
    }

    @Test
    fun testGetNotFound() {
        assertThrows<Exception> { personService.get("1") }
    }

    @Test
    fun testGetSuccess() {
        Mockito.`when`(personRepository.selectById(1)).thenReturn(Person(1, "sammidev","2003113948"))
        Mockito.`when`(personRepository.selectById(2)).thenReturn(Person(2, "sammidev2","20031139482"))

        val person = personService.get("1")
        val person2 = personService.get("2")

        assertEquals(1, person.id)
        assertEquals(2, person2.id)

        assertEquals("sammidev", person.name)
        assertEquals("2003113948", person.nim)
        assertEquals("20031139482", person2.nim)
    }


    @Test
    fun getAllPersonSuccess() {
        val listPerson = listOf(
                Person(1,"sammidev1","2003111"),
                Person(2,"sammidev2","2003112"),
                Person(3,"sammidev3","2003113"),
                Person(4,"sammidev4","2003114"),
                Person(5,"sammidev5","2003115")
        )
        Mockito.`when`(personRepository.selectAll()).thenReturn(listPerson)
        val personList = personService.getAll()

        assertEquals(listPerson, personList)
        assertEquals(listPerson.size, personList.size)
        assertEquals(listPerson[1].name, personList[1].name)
    }

    @Test
    fun getPersonByName() {
        Mockito.`when`(personRepository.getByName("sammidev")).thenReturn( Person(1,"sammidev","2003111"))
        val person = personService.getPersonByName("sammidev")
        assertEquals("sammidev", person.name)
    }
}
