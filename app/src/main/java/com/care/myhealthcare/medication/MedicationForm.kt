package com.care.myhealthcare.medication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_health_news.*
import kotlinx.android.synthetic.main.activity_medication_form.*

class MedicationForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_form)

        setupActionBar()
    }

    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_medication_form)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)

        }

        toolbar_medication_form.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}