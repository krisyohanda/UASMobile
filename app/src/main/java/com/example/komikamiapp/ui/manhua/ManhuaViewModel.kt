package com.example.komikamiapp.ui.manhua

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komikamiapp.network.Manhua
import com.example.komikamiapp.network.ManhuaApi
import kotlinx.coroutines.launch

enum class ManhuaApiStatus { LOADING, ERROR, DONE }

class ManhuaViewModel: ViewModel(){

    private val _status = MutableLiveData<ManhuaApiStatus>()
    val status: LiveData<ManhuaApiStatus> = _status

    private val _manhuas = MutableLiveData<List<Manhua>>()
    val manhuas: LiveData<List<Manhua>> = _manhuas

    private val _manhua = MutableLiveData<Manhua>()
    val manhua: LiveData<Manhua> = _manhua

    fun getManhuaList() {
        viewModelScope.launch {
            _status.value = ManhuaApiStatus.LOADING
            try {
                _manhuas.value = ManhuaApi.retrofitService.getManhua().await().manga_list
                _status.value = ManhuaApiStatus.DONE
            } catch (e: Exception) {
                _manhuas.value = listOf()
                _status.value = ManhuaApiStatus.ERROR
            }
        }
    }

    fun onManhuaClicked(manhua: Manhua) {
        _manhua.value = manhua
    }
}