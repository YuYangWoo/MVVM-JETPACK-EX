package com.example.flow.ui.view.fragment

import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.flow.R
import com.example.flow.databinding.FragmentNewsInformationBinding
import com.example.library.binding.BindingFragment

class NewsInformationFragment : BindingFragment<FragmentNewsInformationBinding>(R.layout.fragment_news_information) {
    private val args: NewsInformationFragmentArgs by navArgs()
    override fun init() {
        super.init()
        with(binding.webView) {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            args.article?.let { article ->
                article.url?.let { loadUrl(it) }
            }
        }
    }
}
