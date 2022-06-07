package com.example.komikami.network

import java.io.Serializable

data class Manga(val title: String,
                  val thumb: String,
                  val type: String,
                  val chapter: String
) : Serializable {}
data class MangaResponse(val status: Boolean,
                          val message: String,
                          val manga_list: List<Manga>){}

data class Manhua(val title: String,
                 val thumb: String,
                 val type: String,
                 val chapter: String
) : Serializable {}
data class ManhuaResponse(val status: Boolean,
                          val message: String,
                          val manga_list: List<Manhua>){}

data class Manhwa(val title: String,
              val thumb: String,
              val type: String,
              val chapter: String
) : Serializable {}
data class ManhwaResponse(val status: Boolean,
                      val message: String,
                      val manga_list: List<Manhwa>){}