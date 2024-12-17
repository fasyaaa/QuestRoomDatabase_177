package com.example.pam7.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pam7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//Data access object / Data manipulated language = operasi
// 3 operasi yang berat / resiko = insert, update, delete harus pake suspend
// interface = sebuah blue print
@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>



}

