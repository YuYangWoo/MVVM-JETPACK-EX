package com.example.flow.ui.view.fragment

import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flow.R
import com.example.flow.databinding.FragmentMainNewsBinding
import com.example.flow.ui.adapter.NewsAdapter
import com.example.flow.ui.viewmodel.MainViewModel
import com.example.flow.ui.viewmodel.UiState
import com.example.library.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainNewsFragment : BindingFragment<FragmentMainNewsBinding>(R.layout.fragment_main_news) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun init() {
        super.init()
        initRequestData()
        initBinding()
        initObserver()
        initRecyclerView()
    }

    private fun initRequestData() {
        mainViewModel.requestNews()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
    }
    private fun initObserver() {
        lifecycleScope.launchWhenCreated {
            mainViewModel.uiState.collect {
                when (it) {
                    is UiState.Success -> {
                        binding.progressBar.visibility = View.GONE
                    }
                    is UiState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is UiState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Log.d("TAG",it.e.message.toString() )
                    }
                    is UiState.Empty -> Unit
                }
            }
        }
        lifecycleScope.launchWhenCreated {
            mainViewModel.newsResponse.collect { news ->
                newsAdapter.submitList(news?.articles)
            }
        }
    }

    private fun initRecyclerView() {
        with(binding.recyclerNews) {
            adapter = newsAdapter
            addItemDecoration(DividerItemDecoration(requireActivity().applicationContext,DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
