package com.example.firstkotlinapp

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    private var date_tv:TextView?=null
    private var lifeInMinutes:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but: Button =findViewById<Button>(R.id.button)
       date_tv =findViewById<TextView>(R.id.textView)
       lifeInMinutes =findViewById<TextView>(R.id.textView2)

        but.setOnClickListener{Data_picker()

        }
    }
    private fun Data_picker(){

        val Calender_obj= Calendar.getInstance()
        val year=Calender_obj.get(Calendar.YEAR)
        val month=Calender_obj.get(Calendar.MONTH)
        val day=Calender_obj.get(Calendar.DAY_OF_MONTH)
       val datepicker= DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            val ans:String="$i3/$i2/$i"
            date_tv?.text=ans
            val sdf =SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate=sdf.parse(ans)
            val the_date_in_minutes=theDate.time/60000
            val currdate=sdf.parse(sdf.format(System.currentTimeMillis()))
            val currdateinmunts=currdate.time/60000
            val defferencInMinutes=currdateinmunts-the_date_in_minutes


            lifeInMinutes?.text=defferencInMinutes.toString()


        },year,month,day)
        datepicker.datePicker.maxDate=System.currentTimeMillis()-86400000
        datepicker.show()

    }
}