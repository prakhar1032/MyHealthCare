package com.care.myhealthcare.diseases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_delete_and_update_diseases.*
import kotlinx.android.synthetic.main.activity_diseases_form.*
import kotlinx.android.synthetic.main.activity_diseases_form.et_description_disease
import kotlinx.android.synthetic.main.activity_diseases_form.et_title_disease
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DeleteAndUpdateDiseases : AppCompatActivity() {
    private lateinit var database : DiseaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_and_update_diseases)
        database = Room.databaseBuilder(applicationContext,
          DiseaseDatabase::class.java,
        "Disease_Database").build()
        val pos = intent.getIntExtra("id",-1)
        if (pos == -1) {
            Toast.makeText(this,
                "No Items To Delete"
               , Toast.LENGTH_SHORT
            ).show()}
        if (pos!=-1) {
            val title = DiseaseObject.getData(pos).title
            val description =  DiseaseObject.getData(pos).description
            et_title_disease.setText(title)
            et_description_disease.setText(description)
            deleteButton.setOnClickListener{
                DiseaseObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteDisease(
                        DiseaseEntity(pos+1,
                            et_title_disease.text.toString(),
                            et_description_disease.text.toString()
                        )
                    )

                }
                myIntent()
            }

        }

    }

    private fun myIntent() {
        val intent = Intent(this, DiseasesActivity::class.java )
        startActivity(intent)
    }
}