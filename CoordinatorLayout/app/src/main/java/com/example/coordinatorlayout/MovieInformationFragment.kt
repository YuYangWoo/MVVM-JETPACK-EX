package com.example.coordinatorlayout

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coordinatorlayout.adapter.MovieAdapter
import com.example.coordinatorlayout.databinding.FragmentMovieInformationBinding
import com.example.library.binding.BindingFragment

class MovieInformationFragment : BindingFragment<FragmentMovieInformationBinding>(R.layout.fragment_movie_information) {
    private val args: MovieInformationFragmentArgs by navArgs()
    override fun init() {
        super.init()
        initDataBinding()
        initRecyclerView()
        initFloatingActionButtonClick()
    }

    private fun initRecyclerView() {
        with(binding.recyclerView) {
            adapter = MovieAdapter().apply {
                submitList(MovieData.movieList)
            }
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
        }
    }

    private fun initDataBinding() {
        binding.movie = args.movie

    }

    private fun initFloatingActionButtonClick() {
        binding.setOnFavorite {
            args.movie.isFavorite = true
            binding.floatingActionButton.hide()
        }
    }
}
