package com.example.pam7.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.pam7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

//Data access object / Data manipulated language = operasi
// 3 operasi yang berat / resiko = insert, update, delete harus pake suspend
// interface = sebuah blue print
@Dao
interface MahasiswaDao {

    @Insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa
    )

    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>

    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim: String): Flow<Mahasiswa>

    @Delete
    suspend fun deleteMahasiswa(
        mahasiswa: Mahasiswa
    )
    @Update
    suspend fun updateMahasiswa(
        mahasiswa: Mahasiswa
    )

}

