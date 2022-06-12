package com.example.komikamiapp.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://manganim.herokuapp.com/manga/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MangaApiService {
    @GET("page/2")
    fun getManga(): Deferred<MangaResponse>
}

interface ManhuaApiService {
    @GET("manhua/1")
    fun getManhua(): Deferred<ManhuaResponse>
}

interface ManhwaApiService {
    @GET("manhwa/1")
    fun getManhwa(): Deferred<ManhwaResponse>
}

interface MangaDetailApiService {
    @GET("detail/{endpoint}")
    fun getMangaDetail(@Path("endpoint") endpoint: String): MangaDetail
}

object MangaApi {
    val retrofitService : MangaApiService by lazy {
        retrofit.create(MangaApiService::class.java)
    }
}

object ManhuaApi {
    val retrofitService : ManhuaApiService by lazy {
        retrofit.create(ManhuaApiService::class.java)
    }
}

object ManhwaApi {
    val retrofitService : ManhwaApiService by lazy {
        retrofit.create(ManhwaApiService::class.java)
    }
}
