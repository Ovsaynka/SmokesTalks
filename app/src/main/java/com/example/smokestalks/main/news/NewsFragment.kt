package com.example.smokestalks.main.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smokestalks.R
import com.example.smokestalks.data.News
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment: Fragment() {

    private val newsList = listOf<News>(
        News("По понедельникам у нас играет джаз и второй коктейль в подарок \uD83D\uDE0E", R.drawable.test_photo),
        News("По понедельникам у нас играет джаз и второй коктейль в подарок \uD83D\uDE0E", R.drawable.test_photo),
        News("По понедельникам у нас играет джаз и второй коктейль в подарок \uD83D\uDE0E", R.drawable.test_photo),
        News("По понедельникам у нас играет джаз и второй коктейль в подарок \uD83D\uDE0E", R.drawable.test_photo),
        News("По понедельникам у нас играет джаз и второй коктейль в подарок \uD83D\uDE0E", R.drawable.test_photo)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NewsAdapter(newsList)
        }
    }
}