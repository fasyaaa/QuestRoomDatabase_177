package com.example.pam7.repository

import com.example.pam7.data.dao.MahasiswaDao
import com.example.pam7.data.entity.Mahasiswa

//untuk menggunakan data / blueprint dari RepositoryMhs
class LocalRepositoryMhs( private val mahasiswaDao: MahasiswaDao ): RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
}