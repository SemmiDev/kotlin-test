package com.sammidev.service

import com.sammidev.entity.Siswa
import com.sammidev.repository.SiswaRepository
import java.util.*

class SiswaService(val siswaRepository: SiswaRepository) {
    fun register(name: String): Siswa {
        val randomID = UUID.randomUUID().toString()
        val siswa = Siswa(randomID, name)
        siswaRepository.insert(siswa)
        return siswa
    }
}