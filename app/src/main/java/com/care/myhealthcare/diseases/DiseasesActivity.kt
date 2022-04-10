package com.care.myhealthcare.diseases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.care.myhealthcare.R
import com.care.myhealthcare.medication.MedicationForm
import kotlinx.android.synthetic.main.activity_diseases.*
import kotlinx.android.synthetic.main.activity_medication.*
import kotlinx.android.synthetic.main.activity_medication.fabAddMedication

class DiseasesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases)

        setupActionBar()

        fabAddDiseases.setOnClickListener {
            val intent = Intent(this, DiseasesForm::class.java)
            startActivity(intent)
        }
    }

    // START
    /**
     * A function to setup action bar
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_diseases)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
            actionBar.title ="Diseases"
        }

        toolbar_diseases.setNavigationOnClickListener { onBackPressed() }
    }
    // END
}