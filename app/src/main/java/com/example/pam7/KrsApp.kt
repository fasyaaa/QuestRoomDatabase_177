package com.example.pam7

import android.app.Application
import com.example.pam7.dependenciesinjection.ContainerApp

// untuk membuat object
class KrsApp : Application() {
    lateinit var containerApp: ContainerApp // Fungsinya untuk menyimpan instance

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) //Membuat instance Container App
//        Instance adalah object yang dibuat dari class
    }
}

// kalau sudah selesai, di daftarkan di manifest (check manifest)