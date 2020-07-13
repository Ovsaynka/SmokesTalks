package com.example.smokestalks.main.news

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.smokestalks.data.News
import kotlinx.android.synthetic.main.news_item.view.*

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(news: News){

        itemView.newsTitleTextView.text = news.newsText
    }
}