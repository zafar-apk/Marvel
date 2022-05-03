package com.education.marvel.presenter.screen.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.education.marvel.App
import com.education.marvel.AppConstants
import com.education.marvel.AppConstants.KEY_CHARACTER_ID
import com.education.marvel.R
import com.education.marvel.databinding.FragmentCharacterDetailsBinding
import com.education.marvel.domain.entity.Character
import com.education.marvel.domain.entity.Image
import com.education.marvel.presenter.screen.details.adapter.DetailsAdapter
import javax.inject.Inject


class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    @Inject
    lateinit var vmFactory: CharacterDetailsViewModel.Factory
    private val viewModel: CharacterDetailsViewModel by viewModels { vmFactory }

    private var binding: FragmentCharacterDetailsBinding? = null

    override fun onAttach(context: Context) {
        (context.applicationContext as? App)?.appComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterId = arguments?.getInt(KEY_CHARACTER_ID)
        characterId?.let(viewModel::getCharacter)

        viewModel.characterLiveData.observe(viewLifecycleOwner, ::setData)
    }

    private fun setData(character: Character) {
        binding?.let { view ->
            with(view) {
                with(details) {
                    val detailsAdapter = DetailsAdapter()
                    detailListRecycler.adapter = detailsAdapter
                    character.details?.let(detailsAdapter::submitList)

                    title.text = character.name
                    character.name?.let(::setupToolbar)

                    date.text = getString(R.string.modified, character.modifiedFormatted)
                    characterImage.load(character.thumbnail?.buildUrl())

                    description.isVisible = !character.description.isNullOrEmpty()
                    description.text = character.description
                }
            }
        }
    }

    private fun Image.buildUrl() = "$path/${AppConstants.THUMBNAIL_MAIN_PATH}.$extension"

    private fun setupToolbar(title: String) {
        binding?.toolbar?.let { toolbar ->
            (activity as? AppCompatActivity)?.apply {
                toolbar.title = title
                setSupportActionBar(toolbar)
                toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                toolbar.setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
    }
}