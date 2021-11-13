package com.care.myhealthcare.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.care.myhealthcare.R
import com.care.myhealthcare.activities.HealthNews
import com.care.myhealthcare.activities.MainActivity

class NewsAdapter(private val context: Context, private var newsList:ArrayList<Article>, private val listener: HealthNews) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.display_news,parent,false))

    override fun getItemCount(): Int =newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news=newsList[position]
        holder.title.text=news.title
        holder.content.text=news.content
        Glide.with(context)
            .load(news.urlToImage)
            .into(holder.image)
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val image: ImageView =itemView.findViewById(R.id.image)
        val title: TextView =itemView.findViewById(R.id.title)
        val content:TextView=itemView.findViewById(R.id.content)
        init {
            itemView.setOnClickListener {
                listener.onItemClickListener(adapterPosition)
            }
        }
    }

    fun setData(newsList: ArrayList<Article>)
    {
        this.newsList=newsList
        notifyDataSetChanged()
    }

}
