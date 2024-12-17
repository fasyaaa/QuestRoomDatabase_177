package com.example.pam7.repository

import com.example.pam7.data.dao.MahasiswaDao
import com.example.pam7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//untuk menggunakan data / blueprint dari RepositoryMhs
class LocalRepositoryMhs(private val mahasiswaDao: MahasiswaDao ): RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)

    }

//    Metode ini memanggil fungsi getAllMahasiswa dari MahasiswaDao untuk mendapatkan semua data mahasiswa dalam bentuk aliran data (Flow).
    override fun getAllMhs(): Flow<List<Mahasiswa>> {
        return (mahasiswaDao.getAllMahasiswa())
    }

//    Metode ini memanggil fungsi getMahas iswa dari MahasiswaDao untuk mengambil data mahasiswa berdasarkan NIM.
    override fun getMhs(nim: String): Flow<Mahasiswa> {
        return (mahasiswaDao.getMahasiswa(nim))
    }

//    Metode ini memanfaatkan fungsi de leteMahasiswa dari MahasiswaDao untuk menghapus data mahasiswa.
    override suspend fun deleteMhs(mahasiswa: Mahasiswa) {
        return (mahasiswaDao.deleteMahasiswa(mahasiswa))
    }

//    Metode ini menggunakan fungsi updateMahasiswa dari Mahas iswaDao untuk memperbarui data mahasiswa di database.
    override suspend fun updateMHs(mahasiswa: Mahasiswa) {
        return (mahasiswaDao.updateMahasiswa(mahasiswa))
    }

}
