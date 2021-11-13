package com.care.myhealthcare.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.care.myhealthcare.R
import com.care.myhealthcare.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HealthNews : AppCompatActivity(),Listener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var articlesList: ArrayList<Article>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_news)
        setUpUi()
        fetchData()
    }
    private fun setUpUi() {
        recyclerView=findViewById(R.id.recyclerView)
        newsAdapter= NewsAdapter(this,ArrayList<Article>(),this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@HealthNews)
            adapter=newsAdapter
        }
    }


    private fun fetchData() {
        val call: Call<NewsX> = ApiClient.newApi.getNews("in", "health", Constants.API_KEY)
        call.enqueue(object : Callback<NewsX> {

            override fun onResponse(call: Call<NewsX>, response: Response<NewsX>) {
                if (response.isSuccessful) {
                    val listArticles = response.body()?.articles
                    if (listArticles != null && listArticles.isNotEmpty()) {
                        newsAdapter.setData(listArticles as ArrayList<Article>)


                        recyclerView.visibility = View.VISIBLE
                    }
                    articlesList = response.body()?.articles as ArrayList<Article>
                }
            }

            override fun onFailure(call: Call<NewsX>, t: Throwable) {
                Log.d("main", "onFailure: ${t.message}")
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_LONG).show()


            }


        })
    }
    override fun onItemClickListener(position :Int) {
        val intent = Intent(this, web::class.java)
        intent.putExtra("url",articlesList[position].url)
        startActivity(intent)
    }
}