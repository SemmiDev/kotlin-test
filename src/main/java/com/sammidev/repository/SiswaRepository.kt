package com.sammidev.repository

import com.sammidev.entity.Siswa

interface SiswaRepository {
    fun insert(siswa: Siswa)
}