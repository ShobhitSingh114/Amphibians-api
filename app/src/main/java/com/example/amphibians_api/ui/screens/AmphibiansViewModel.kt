package com.example.amphibians_api.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians_api.AmphibiansApplication
import com.example.amphibians_api.data.AmphibiansRepository
import com.example.amphibians_api.model.Amphibian
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface AmphibianUiState {
    data class Success(val amphibians: List<Amphibian>): AmphibianUiState
    data object Error: AmphibianUiState
    data object Loading: AmphibianUiState
}

class AmphibiansViewModel(val amphibiansRepository: AmphibiansRepository): ViewModel() {
    var amphibianUiState: AmphibianUiState by mutableStateOf(AmphibianUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            amphibianUiState = AmphibianUiState.Loading
            amphibianUiState = try {
                AmphibianUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibianUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibiansApplication)
                val amphibianRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibianRepository)
            }

        }
    }

}
