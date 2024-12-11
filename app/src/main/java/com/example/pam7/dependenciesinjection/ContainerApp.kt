package com.example.pam7.dependenciesinjection

import android.content.Context
import com.example.pam7.data.database.KrsDatabase
import com.example.pam7.repository.LocalRepositoryMhs
import com.example.pam7.repository.RepositoryMhs

// repository yang ingin digunakan dimasukkan di sini
interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs
}
// untuk impelementasi dari interfacecontainerapp
// Untuk mengakses local repository mhs
class ContainerApp(private val context: Context) : InterfaceContainerApp{
    override val repositoryMhs: RepositoryMhs by lazy {
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}