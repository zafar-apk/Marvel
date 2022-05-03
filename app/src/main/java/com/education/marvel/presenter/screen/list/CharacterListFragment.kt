package com.education.marvel.presenter.screen.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.education.marvel.App
import com.education.marvel.AppConstants.KEY_CHARACTER_ID
import com.education.marvel.R
import com.education.marvel.databinding.FragmentCharacterListBinding
import com.education.marvel.presenter.screen.list.adapter.CharactersAdapter
import com.education.marvel.presenter.util.EndlessRecyclerViewScrollListener
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject

class CharacterListFragment : Fragment(R.layout.fragment_character_list) {

    @Inject
    lateinit var viewModelFactory: CharacterListViewModel.Factory
    private val viewModel: CharacterListViewModel by viewModels { viewModelFactory }

    private var binding: FragmentCharacterListBinding? = null

    private val charactersAdapter by lazy {
        CharactersAdapter(::onCharacterClicked)
    }

    private val gridLayoutManager by lazy {
        GridLayoutManager(requireContext(), 2)
    }

    private val pagingScrollListener by lazy {
        EndlessRecyclerViewScrollListener(gridLayoutManager) { page, _, _ ->
            viewModel.getCharacters(page)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onAttach(context: Context) {
        (context.applicationContext as? App)?.appComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.characters.observe(viewLifecycleOwner, charactersAdapter::submitList)
        viewModel.error.observe(viewLifecycleOwner, ::onError)
        viewModel.loading.observe(viewLifecycleOwner, ::onLoadingChanged)

    }

    private fun onLoadingChanged(loading: Boolean) {
        binding?.progressBar?.isVisible = loading
    }

    private fun onError(throwable: Throwable?) {
        Log.d(javaClass.simpleName, throwable?.localizedMessage.orEmpty())

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                showErrorSnackbar()
            }
        }
    }

    private suspend fun showErrorSnackbar() = suspendCancellableCoroutine<Unit> { continuation ->
        view?.let { view ->
            val snackbar = Snackbar.make(view, R.string.error_message, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.retry) {
                    viewModel.retry()
                }
            snackbar.show()
            continuation.invokeOnCancellation { snackbar.dismiss() }
        }
    }

    private fun onCharacterClicked(id: Int) {
        findNavController().navigate(
            R.id.action_characterListFragment_to_characterDetailsFragment,
            bundleOf(KEY_CHARACTER_ID to id)
        )
    }

    private fun setupRecyclerView() {
        binding?.charactersRecyclerView?.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = charactersAdapter
            addOnScrollListener(pagingScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}