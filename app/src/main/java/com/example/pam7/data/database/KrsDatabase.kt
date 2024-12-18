package com.example.pam7.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pam7.data.dao.MahasiswaDao
import com.example.pam7.data.entity.Mahasiswa

//Mendefinisikan fungsi untuk mengakses data Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase: RoomDatabase(){

//    Mendefinisian fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile // Memastikan bahwa nilai variable Instance selalu sama di semua
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase{
            return (Instance ?: synchronized(this){
//                membuat database
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //Class database
                    "KrsDatabase" //Nama Database
                )
                    .build().also { Instance = it }
            })
        }
    }
}