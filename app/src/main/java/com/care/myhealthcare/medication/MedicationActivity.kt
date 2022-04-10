package com.care.myhealthcare.medication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_medication.*

class MedicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication)

        setupActionBar()

        fabAddMedication.setOnClickListener {
            val intent = Intent(this,MedicationForm::class.java)
            startActivity(intent)
        }
    }

    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_medication)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title ="Medication"
        }

        toolbar_medication.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}