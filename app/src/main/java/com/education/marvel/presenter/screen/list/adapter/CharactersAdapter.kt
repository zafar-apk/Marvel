package com.education.marvel.presenter.screen.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.education.domain.entity.Character
import com.education.marvel.R
import com.education.marvel.presenter.util.buildListItemUrl

class CharactersAdapter(
    private val onCharacterClicked: (Int) -> Unit
) : ListAdapter<Character, CharactersViewHolder>(CharacterDiffUtil.callback) {

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
            holder.imageView.load(character.thumbnail?.buildListItemUrl())
            holder.itemView.setOnClickListener {
                onCharacterClicked(character.id ?: return@setOnClickListener)
            }
        }
    }

}
