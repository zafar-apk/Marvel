package com.education.list.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.education.domain.entity.Character

object CharacterDiffUtil {

    val callback = object : DiffUtil.ItemCallback<Character>() {
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