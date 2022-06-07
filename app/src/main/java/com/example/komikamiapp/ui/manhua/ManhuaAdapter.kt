package com.example.komikamiapp.ui.manhua

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.komikamiapp.databinding.ManhuaRowBinding
import com.example.komikamiapp.network.Manhua

class ManhuaAdapter(private val clickListener: ManhuaListener) :
    ListAdapter<Manhua, ManhuaAdapter.ManhuaViewHolder>(DiffCallback)
{
        class ManhuaViewHolder(
            var binding: ManhuaRowBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(clickListener: ManhuaListener, manhua: Manhua) {
                binding.manhua = manhua
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Manhua>() {
        override fun areItemsTheSame(oldItem: Manhua, newItem: Manhua): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Manhua, newItem: Manhua): Boolean {
            return oldItem.type == newItem.type && oldItem.chapter == newItem.chapter && oldItem.thumb == newItem.thumb
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManhuaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ManhuaViewHolder(
            ManhuaRowBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ManhuaViewHolder, position: Int) {
        val manhua = getItem(position)
        holder.bind(clickListener, manhua)
    }

}
class ManhuaListener(val clickListener: (manhua: Manhua) -> Unit) {
    fun onClick(manhua: Manhua) = clickListener(manhua)
}