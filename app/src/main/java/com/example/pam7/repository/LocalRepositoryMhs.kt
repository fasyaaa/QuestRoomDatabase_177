package com.example.pam7.repository

import com.example.pam7.data.dao.MahasiswaDao
import com.example.pam7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//untuk menggunakan data / blueprint dari RepositoryMhs
class LocalRepositoryMhs(private val mahasiswaDao: MahasiswaDao ): RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)

    }

    override fun getAllMhs(): Flow<List<Mahasiswa>> {
        return (mahasiswaDao.getAllMahasiswa())
    }

    override fun getMhs(nim: String): Flow<Mahasiswa> {
        return (mahasiswaDao.getMahasiswa(nim))
    }

    override suspend fun deleteMhs(mahasiswa: Mahasiswa) {
        return (mahasiswaDao.deleteMahasiswa(mahasiswa))
    }

    override suspend fun updateMHs(mahasiswa: Mahasiswa) {
        return (mahasiswaDao.updateMahasiswa(mahasiswa))
    }

}
