package com.example.flow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flow.data.model.News
import com.example.flow.data.repository.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Empty)
    val uiState: StateFlow<UiState> = _uiState
    private val _newsResponse = MutableStateFlow(News())
    val newsResponse: StateFlow<News?> = _newsResponse

    fun requestNews() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        remoteRepository.requestNews()
            .catch { e ->
                _uiState.value = UiState.Error(e as Exception)
            }.collect { data ->
                _newsResponse.value = data
                _uiState.value = UiState.Success
        }
    }
}

sealed class UiState {
    object Success: UiState()
    object Loading: UiState()
    data class Error(val e: Exception): UiState()
    object Empty: UiState()
}
