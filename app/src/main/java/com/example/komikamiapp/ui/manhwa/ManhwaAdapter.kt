package com.example.komikamiapp.ui.manhwa

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.komikamiapp.databinding.ManhwaRowBinding
import com.example.komikamiapp.network.Manhwa

class ManhwaAdapter(private val clickListener: ManhwaListener) :
    ListAdapter<Manhwa, ManhwaAdapter.ManhwaViewHolder>(DiffCallback)
{
    class ManhwaViewHolder(
        var binding: ManhwaRowBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: ManhwaListener, manhwa: Manhwa) {
            binding.manhwa = manhwa
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Manhwa>() {
        override fun areItemsTheSame(oldItem: Manhwa, newItem: Manhwa): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Manhwa, newItem: Manhwa): Boolean {
            return oldItem.type == newItem.type && oldItem.chapter == newItem.chapter && oldItem.thumb == newItem.thumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManhwaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ManhwaViewHolder(
            ManhwaRowBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ManhwaViewHolder, position: Int) {
        val manhwa = getItem(position)
        holder.bind(clickListener, manhwa)
    }

}
class ManhwaListener(val clickListener: (manhwa: Manhwa) -> Unit) {
    fun onClick(manhwa: Manhwa) = clickListener(manhwa)
}