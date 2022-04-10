package com.care.myhealthcare.diseases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_diseases_form.*
import kotlinx.android.synthetic.main.activity_medication_form.*

class DiseasesForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases_form)

        setupActionBar()
    }

    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_diseases_form)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)

        }

        toolbar_diseases_form.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}