package com.care.myhealthcare.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_web.*

class web : AppCompatActivity() {
    private lateinit var  url :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val bundle=intent.extras
        if(bundle != null){
            url= bundle.getString("url").toString()
        }
        web_view.loadUrl(url)
    }
}