package com.education.marvel.presenter.screen.list.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.education.marvel.R

class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.image)
    val name: TextView = itemView.findViewById(R.id.name)
}