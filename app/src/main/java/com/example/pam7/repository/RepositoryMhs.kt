package com.example.pam7.repository

import com.example.pam7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

// berhubungan dengan view model agar bisa di akses di view model
interface RepositoryMhs {
//    Untuk menyimpan data yang sudah di input
//    operasi sesuai dengan ada yang di DAO
    suspend fun insertMhs(mahasiswa: Mahasiswa)

//    Operasi memanggil dari MahasiswaDao untuk dapat semua aliran data (Flow)
    fun getALlMhs(): Flow<List<Mahasiswa>>

    fun getMhs(nim: String): Flow<Mahasiswa>

    suspend fun deleteMhs(mahasiswa: Mahasiswa)
}