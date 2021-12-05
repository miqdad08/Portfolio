package com.miqdad.portfolio.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miqdad.portfolio.R
import com.miqdad.portfolio.data.Portfolio
import com.miqdad.portfolio.databinding.ItemExperienceBinding

class RVExperienceAdapter : RecyclerView.Adapter<RVExperienceAdapter.ExperienceViewHolder>() {

    private val listData = ArrayList<Portfolio>()

    var onItemClicked: ((Portfolio) -> Unit)? = null

    fun setData(data: List<Portfolio>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder =
        ExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        )

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val listData = listData[position]
        holder.bind(listData)
    }

    override fun getItemCount(): Int = listData.size


    inner class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemExperienceBinding.bind(itemView)

        fun bind(data: Portfolio) {
            binding.experience = data
            binding.executePendingBindings()
        }

        init {
            binding.root.setOnClickListener {
                onItemClicked?.invoke(listData[adapterPosition])
            }
        }
    }
}