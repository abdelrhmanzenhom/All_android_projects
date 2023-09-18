package com.example.quezapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startbt: Button =findViewById(R.id.startBT)
val intent= Intent(this,QuestionActivity::class.java)
        val name:TextView=findViewById(R.id.nameET)
        startbt.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"please enter your name first",Toast.LENGTH_LONG).show()
            }
            else{
                intent.putExtra(Constants.USER_NAME,name.text.toString())

startActivity(intent)
                finish()
            }
        }
    }
}