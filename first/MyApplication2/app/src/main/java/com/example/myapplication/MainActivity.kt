package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn:Button=findViewById(R.id.btnLogin)
        btn.setOnClickListener {
            // Perform login logic here
            // Once login is successful, start the MainActivity
            val intent = Intent(this@MainActivity, SplashScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}