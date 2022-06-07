package com.example.komikamiapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.komikamiapp.network.Manga
import com.example.komikamiapp.ui.manhua.ManhuaApiStatus
import com.example.komikamiapp.ui.manhwa.ManhwaAdapter
import com.example.komikamiapp.ui.manhwa.ManhwaApiStatus
import com.example.komikamiapp.network.Manhua
import com.example.komikamiapp.network.Manhwa
import com.example.komikamiapp.ui.manga.MangaAdapter
import com.example.komikamiapp.ui.manga.MangaApiStatus
import com.example.komikamiapp.ui.manhua.ManhuaAdapter

@BindingAdapter("listData1")
fun bindRecyclerViews(recyclerView: RecyclerView, data: List<Manga>?){
    val adapter = recyclerView.adapter as MangaAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData2")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Manhua>?){
    val adapter = recyclerView.adapter as ManhuaAdapter
    adapter.submitList(data)
}

@BindingAdapter("listData3")
fun bindRecyclerViewz(recyclerView: RecyclerView, data: List<Manhwa>?){
    val adapter = recyclerView.adapter as ManhwaAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let{
        Glide.with(imgView.context)
            .load(it)
            .apply(
                RequestOptions())
            .into(imgView)
    }
}

@BindingAdapter("apiStatus1")
fun bindStatus(statusImageView: ImageView, status: MangaApiStatus?) {
    when (status) {
        MangaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        MangaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        MangaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus2")
fun bindStatus(statusImageView: ImageView, status: ManhuaApiStatus?) {
    when (status) {
        ManhuaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        ManhuaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ManhuaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}

@BindingAdapter("apiStatus3")
fun bindStatus(statusImageView: ImageView, status: ManhwaApiStatus?) {
    when (status) {
        ManhwaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
        }
        ManhwaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        ManhwaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}