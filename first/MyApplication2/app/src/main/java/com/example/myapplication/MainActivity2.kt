package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
val frag1=first()
        val frag2=Second()
        val bt:Button=findViewById(R.id.button)
        val bt2:Button=findViewById(R.id.button2)




        bt.setOnClickListener{
supportFragmentManager.beginTransaction().apply { replace(R.id.fragmentxxx,frag2)

            commit()}


        }
        bt2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply { replace(R.id.fragmentxxx,frag1)
                commit() }

        }
    }


}