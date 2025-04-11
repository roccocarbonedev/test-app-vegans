package com.roccocarbone.testandroidcarbone.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roccocarbone.testandroidcarbone.data.models.Media
import com.roccocarbone.testandroidcarbone.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MasterViewModel : ViewModel() {

    private val repository = Repository()

    private val _mediaResults = MutableStateFlow<List<Media>>(emptyList())
    val mediaResults: StateFlow<List<Media>> = _mediaResults

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchMedia() {
        _isLoading.value = true
        _errorMessage.value = null
        _mediaResults.value = emptyList()

        viewModelScope.launch {
            try {
                val response = repository.fetchMedia()
                _mediaResults.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Errore: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }


    fun deleteMedia(id: Int) {
        _mediaResults.value = _mediaResults.value.filterNot { it.mediaId == id }
    }

}