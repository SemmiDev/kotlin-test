package com.sammidev.mockito

import com.sammidev.entity.Siswa
import com.sammidev.repository.SiswaRepository
import com.sammidev.service.SiswaService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@ExtendWith(value = [MockitoExtension::class])
class SiswaMockingTest {

        @Mock
        lateinit var siswaRespository: SiswaRepository
        lateinit var siswaService: SiswaService

        @BeforeEach
        fun before() {
            siswaService = SiswaService(siswaRespository)
        }

        @Test
        fun testRegiisterSuccess() {
                val siswa = siswaService.register("sammidev")
                assertEquals("sammidev", siswa.name)
                assertNotNull(siswa.id)

                // verifikasi
                Mockito.verify(siswaRespository, Mockito.times(1))
                        .insert(Siswa(siswa.id, siswa.name))
        }
}