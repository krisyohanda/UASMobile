package com.example.komikamiapp.ui.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.komikamiapp.network.Manga
import com.example.komikamiapp.network.MangaApi
import kotlinx.coroutines.launch

enum class MangaApiStatus { LOADING, ERROR, DONE }

class MangaViewModel: ViewModel(){

    private val _status = MutableLiveData<MangaApiStatus>()
    val status: LiveData<MangaApiStatus> = _status

    private val _mangas = MutableLiveData<List<Manga>>()
    val mangas: LiveData<List<Manga>> = _mangas

    private val _manga = MutableLiveData<Manga>()
    val manga: LiveData<Manga> = _manga

    fun getMangaList() {
        viewModelScope.launch {
            _status.value = MangaApiStatus.LOADING
            try {
                _mangas.value = MangaApi.retrofitService.getManga().await().manga_list
                _status.value = MangaApiStatus.DONE
            } catch (e: Exception) {
                _mangas.value = listOf()
                _status.value = MangaApiStatus.ERROR
            }
        }
    }

    fun onMangaClicked(manga: Manga) {
        _manga.value = manga
    }
}