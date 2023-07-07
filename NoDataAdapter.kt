package com.zapp.app.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zapp.app.databinding.NoDataCardBinding

class NoDataAdapter : ListAdapter<String, NoDataAdapter.ViewHolder>(DiffCallback()) {
    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,  
            newItem: String
        ): Boolean {
            return oldItem == newItem  //oldItem.id == newItem.id   in case of object
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }
    inner class ViewHolder(private val binding: NoDataCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            if (item.equals("error"))
            {
                binding.ivThumb.hide()
                binding.ivThumbError.show()
            }
            else {
                binding.ivThumb.show()
                binding.ivThumbError.hide()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = NoDataCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           val item= getItem(position)
        holder.bind(item)
    }


}
