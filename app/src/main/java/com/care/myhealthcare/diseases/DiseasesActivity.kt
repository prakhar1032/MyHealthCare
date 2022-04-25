package com.care.myhealthcare.diseases

import android.content.Entity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_delete_and_update_diseases.*
import kotlinx.android.synthetic.main.activity_diseases.*
import kotlinx.android.synthetic.main.activity_diseases_form.*
import kotlinx.android.synthetic.main.activity_diseases_form.et_description_disease
import kotlinx.android.synthetic.main.activity_diseases_form.et_title_disease
import kotlinx.android.synthetic.main.disease_view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DiseasesActivity : AppCompatActivity() {
    private lateinit var database: DiseaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseases)
    database = Room.databaseBuilder(
        applicationContext,
        DiseaseDatabase::class.java,
        "Disease_Database"
    ).build()
        setupActionBar()

        fabAddDiseases.setOnClickListener {
            val intent = Intent(this, DiseasesForm::class.java)
            startActivity(intent)
        }


        setRecycler()

    }
       fun setRecycler() {
           recycler_view.adapter = DiseaseAdapter(DiseaseObject.getAllData())
           recycler_view.layoutManager = LinearLayoutManager(this)

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