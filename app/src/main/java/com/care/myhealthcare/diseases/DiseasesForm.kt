package com.care.myhealthcare.diseases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_diseases_form.*
import kotlinx.android.synthetic.main.activity_medication_form.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DiseasesForm : AppCompatActivity() {
    private lateinit var database :DiseaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases_form)
        setupActionBar()

        database = Room.databaseBuilder(
            applicationContext
            , DiseaseDatabase::class.java,
            "Disease_Database"
        ).build()
        save.setOnClickListener {
            if(et_title_disease.text.toString().isNotEmpty() && et_description_disease.text.toString().isNotEmpty()) {
                var title = et_title_disease.getText().toString()
                var description = et_description_disease.getText().toString()
                DiseaseObject.setData(title, description)
                GlobalScope.launch {

                    database.dao().insertDisease(DiseaseEntity(0, title, description))
                }
                val intent = Intent(this , DiseasesActivity::class.java)
                startActivity(intent)
            }

        }
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