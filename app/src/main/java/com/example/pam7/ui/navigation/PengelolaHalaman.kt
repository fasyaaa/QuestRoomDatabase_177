package com.example.pam7.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pam7.ui.view.mahasiswa.DestinasiInsert
import com.example.pam7.ui.view.mahasiswa.InsertMhsView

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){
    NavHost(navController = navController,
        startDestination = DestinasiInsert.route)
    {
        composable(
            route = DestinasiInsert.route)
        {
            InsertMhsView(
                onBack = {},
                onNavigate = {}
            )
        }
    }
}