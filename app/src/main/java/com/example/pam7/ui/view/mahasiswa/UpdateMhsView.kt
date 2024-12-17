package com.example.pam7.ui.view.mahasiswa

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pam7.ui.costumwidget.TopAppBar
import com.example.pam7.ui.viewmodel.PenyediaViewModel
import com.example.pam7.ui.viewmodel.UpdateMhsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun UpdateMhsViewModel(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory) //Inisialisasi viewmodel
){
    val uiState = viewModel.updateUIState //Ambil UI state dari ViewModel
    val snackbarHostState = remember { SnackbarHostState() } //Snackbar state
    val coroutineScope = rememberCoroutineScope()

//    Observasi perubahan snackbarMessage
    LaunchedEffect(uiState.snackbarMessage) { }
    println("LaunchedEffect triggered")
    uiState.snackbarMessage?.let { message ->
        println("Snackbar message received: $message")
        coroutineScope.launch {
            println("Launching coroutine for snackbar")
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Long
            )
            viewModel.resetSnackBarMessage()
        }
    }

    Scaffold (modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)},
            topBar = {
                TopAppBar(
                    judul = "Edit Mahasiswa",
                    showBackButton = true,
                    onBack = onBack,
                )
            }
        ){ padding ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
        ){
            InsertBodyMhs(
                uiState = uiState,
                onValueChange = {updateEvent ->
                    viewModel.updateState(updateEvent) //Update State di View Model
                },
                onClick = {
                    coroutineScope.launch {
                        if (viewModel.validateFields()){
                            viewModel.updateData()
                            delay(600)
                            withContext(Dispatchers.Main){
                                onNavigate() //Navigasi di main thread
                            }
                        }
                    }
                }
            )
        }
    }
}