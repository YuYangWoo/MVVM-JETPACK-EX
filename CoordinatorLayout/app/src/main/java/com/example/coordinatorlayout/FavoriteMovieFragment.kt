package com.example.coordinatorlayout

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.coordinatorlayout.adapter.MovieAdapter
import com.example.coordinatorlayout.databinding.FragmentFavoriteMovieBinding
import com.example.library.binding.BindingFragment
import javax.inject.Inject

class FavoriteMovieFragment : BindingFragment<FragmentFavoriteMovieBinding>(R.layout.fragment_favorite_movie) {

    override fun init() {
        super.init()
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()
    }
    private fun initRecyclerView() {
        Log.d("TAG", "영화리스트는")

        with(binding.recyclerView) {
            adapter = MovieAdapter().apply {
                submitList(MovieData.movieList.filter {
                    it.isFavorite })
            }
            addItemDecoration(GridSpacingItemDecoration(2, 5.toDp()))
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
                gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
            }
        }
    }

}
