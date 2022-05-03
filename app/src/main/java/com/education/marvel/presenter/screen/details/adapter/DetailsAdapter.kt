package com.education.marvel.presenter.screen.details.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    private var items: List<String> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<String>){
        items = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_spinner_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.content.text = items[position]
    }

    override fun getItemCount() = items.size
}