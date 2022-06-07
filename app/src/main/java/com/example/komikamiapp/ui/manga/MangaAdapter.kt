package com.example.komikamiapp.ui.manga

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.komikamiapp.databinding.MangaRowBinding
import com.example.komikamiapp.network.Manga

class MangaAdapter(private val clickListener: MangaListener) :
    ListAdapter<Manga, MangaAdapter.MangaViewHolder>(DiffCallback)
{
        class MangaViewHolder(
            var binding: MangaRowBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(clickListener: MangaListener, manga: Manga) {
                binding.manga = manga
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Manga>() {
        override fun areItemsTheSame(oldItem: Manga, newItem: Manga): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Manga, newItem: Manga): Boolean {
            return oldItem.type == newItem.type && oldItem.chapter == newItem.chapter && oldItem.thumb == newItem.thumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MangaViewHolder(
            MangaRowBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        val manga = getItem(position)
        holder.bind(clickListener, manga)
    }

}
class MangaListener(val clickListener: (manga: Manga) -> Unit) {
    fun onClick(manga: Manga) = clickListener(manga)
}