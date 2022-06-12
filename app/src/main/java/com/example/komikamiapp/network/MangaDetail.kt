package com.example.komikamiapp.network

import com.squareup.moshi.Json

data class MangaDetail(

    @Json(name="genre_list")
    val genreList: List<GenreListItem?>? = null,

    @Json(name="chapter")
    val chapter: List<ChapterItem?>? = null,

    @Json(name="thumb")
    val thumb: String? = null,

    @Json(name="author")
    val author: String? = null,

    @Json(name="synopsis")
    val synopsis: String? = null,

    @Json(name="title")
    val title: String? = null,

    @Json(name="type")
    val type: String? = null,

    @Json(name="manga_endpoint")
    val mangaEndpoint: String? = null,

    @Json(name="status")
    val status: String? = null
)

data class GenreListItem(

    @Json(name="genre_name")
    val genreName: String? = null
)

data class ChapterItem(

    @Json(name="chapter_endpoint")
    val chapterEndpoint: String? = null,

    @Json(name="chapter_title")
    val chapterTitle: String? = null
)
