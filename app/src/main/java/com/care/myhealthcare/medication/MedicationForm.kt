package com.care.myhealthcare.medication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.care.myhealthcare.R
import kotlinx.android.synthetic.main.activity_health_news.*
import kotlinx.android.synthetic.main.activity_medication_form.*
import java.util.*

class MedicationForm : AppCompatActivity()  , DatePickerDialog.OnDateSetListener , TimePickerDialog.OnTimeSetListener {
    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute  = 0

    var savedday = 0
    var savedmonth = 0
    var savedyear = 0
    var savedhour = 0
    var savedminute  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_form)

        setupActionBar()
        pickDate()
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
   private fun getDateAndTime() {
        val calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month  = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
    }
    private fun pickDate() {
        setDateAndTime.setOnClickListener{
            getDateAndTime()
            DatePickerDialog(this,this,year,month,day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedyear = year
        savedmonth = month
        savedday = dayOfMonth
        getDateAndTime()
        TimePickerDialog(this,this,hour,minute,true).show()
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        savedhour = hour
        savedminute = minute
        medicine_date.text = "Medicine date is: $savedday-${savedmonth+1}-$savedyear "
           medicine_time.text =     "Medicine time is : $savedhour:$savedminute"
    }

}