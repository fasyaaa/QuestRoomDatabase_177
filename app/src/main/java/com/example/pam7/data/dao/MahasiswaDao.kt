package com.example.pam7.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.pam7.data.entity.Mahasiswa

//Data access object / Data manipulated language = operasi
// 3 operasi yang berat / resiko = insert, update, delete harus pake suspend
// interface = sebuah blue print
@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

}