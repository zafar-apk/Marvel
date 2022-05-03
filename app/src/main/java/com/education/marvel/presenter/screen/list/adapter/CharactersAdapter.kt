package com.education.marvel.presenter.screen.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.education.marvel.AppConstants.THUMBNAIL_PATH
import com.education.marvel.R
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.entity.Image

class CharactersAdapter(
    private val onCharacterClicked: (Int) -> Unit
) : ListAdapter<Character, CharactersViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ) = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ) = oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = CharactersViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
    )


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.name.text = character.name
            holder.imageView.load(character.thumbnail?.buildUrl())
            holder.itemView.setOnClickListener {
                onCharacterClicked(character.id ?: return@setOnClickListener)
            }
        }
    }

    private fun Image.buildUrl() = "$path/$THUMBNAIL_PATH.$extension"

}
