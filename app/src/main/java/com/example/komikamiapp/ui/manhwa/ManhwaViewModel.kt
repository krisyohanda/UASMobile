package com.example.komikamiapp.ui.manhwa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komikamiapp.network.Manhwa
import com.example.komikamiapp.network.ManhwaApi
import kotlinx.coroutines.launch

enum class ManhwaApiStatus { LOADING, ERROR, DONE }

class ManhwaViewModel: ViewModel(){

    private val _status = MutableLiveData<ManhwaApiStatus>()
    val status: LiveData<ManhwaApiStatus> = _status

    private val _manhwas = MutableLiveData<List<Manhwa>>()
    val manhwas: LiveData<List<Manhwa>> = _manhwas

    private val _manhwa = MutableLiveData<Manhwa>()
    val manhwa: LiveData<Manhwa> = _manhwa

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getManhwaList() {
        viewModelScope.launch {
            _status.value = ManhwaApiStatus.LOADING
            try {
                _manhwas.value = ManhwaApi.retrofitService.getManhwa().await().manga_list
                _status.value = ManhwaApiStatus.DONE
            } catch (e: Exception) {
                _manhwas.value = listOf()
                _status.value = ManhwaApiStatus.ERROR
            }
        }
    }

    fun onManhwaClicked(manhwa: Manhwa) {
        _manhwa.value = manhwa
    }
}