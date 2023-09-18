package com.example.quezapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResulteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resulte)
    val tvName:TextView=findViewById(R.id.tv_name)
        val tvscore:TextView=findViewById(R.id.tv_score)
        val btnFinish: Button =findViewById(R.id.btn_finish)
        tvName.text=intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANS,0)
        tvscore.text="your score is $correctAnswers out of $totalQuestions"
        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}