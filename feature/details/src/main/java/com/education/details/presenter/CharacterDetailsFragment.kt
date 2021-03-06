package com.education.details.presenter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.education.details.R
import com.education.details.databinding.FragmentCharacterDetailsBinding
import com.education.details.di.DaggerFeatureDetailsComponent
import com.education.details.di.FeatureDetailsDepsProvider
import com.education.details.presenter.adapter.DetailsAdapter
import com.education.domain.AppConstants.KEY_CHARACTER_ID
import com.education.domain.entity.Character
import com.education.domain.util.buildDetailImageUrl
import javax.inject.Inject


class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    @Inject
    lateinit var viewModel: CharacterDetailsViewModel

    private var binding: FragmentCharacterDetailsBinding? = null

    override fun onAttach(context: Context) {
        (context.applicationContext as? FeatureDetailsDepsProvider)?.featureDetailsDeps?.let { deps ->
            DaggerFeatureDetailsComponent.builder()
                .deps(deps)
                .build()
                .inject(this)
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterId = arguments?.getInt(KEY_CHARACTER_ID)
        characterId?.let(viewModel::getCharacter)

        viewModel.characterLiveData.observe(viewLifecycleOwner, ::setData)
    }

    private fun setData(character: Character) {
        binding?.let { view ->
            view.characterImage.load(character.thumbnail?.buildDetailImageUrl())

            with(view.details) {
                val detailsAdapter = DetailsAdapter()
                detailListRecycler.adapter = detailsAdapter
                character.details?.let(detailsAdapter::submitList)

                title.text = character.name
                character.name?.let(::setupToolbar)

                date.text = getString(R.string.modified, character.modifiedFormatted)

                description.isVisible = !character.description.isNullOrEmpty()
                description.text = character.description
            }
        }
    }

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