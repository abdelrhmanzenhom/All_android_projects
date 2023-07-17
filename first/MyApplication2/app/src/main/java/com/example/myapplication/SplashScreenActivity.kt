package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}