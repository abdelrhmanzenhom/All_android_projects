package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var output:TextView?=null
    var numberBefor:Boolean=false
    var decimalBefore:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        output=findViewById<TextView>(R.id.TV_OUTPUT)


    }
    fun Equal(view:View){
        if(numberBefor) {
            var minuesInfront:Boolean=false
        var value=output?.text.toString()
            if(value.startsWith("-"))minuesInfront=true
            if(!minuesInfront){

                if(value.contains("-")){
            val splitedarray=value.split('-')
            output?.text=zeroRemover((splitedarray[0].toDouble()-splitedarray[1].toDouble()).toString())}
               else if(value.contains("+")){
                    val splitedarray=value.split('+')
                    output?.text=zeroRemover((splitedarray[0].toDouble()+splitedarray[1].toDouble()).toString())}
                else if(value.contains("*")){
                    val splitedarray=value.split('*')
                    output?.text=zeroRemover((splitedarray[0].toDouble()*splitedarray[1].toDouble()).toString())}
                else if(value.contains("/")){
                    val splitedarray=value.split('/')
                    output?.text=zeroRemover((splitedarray[0].toDouble()/splitedarray[1].toDouble()).toString())}

            }
            else{ var val2=value.substring(1)
                if(val2.contains("-")){

                val splitedarray=val2.split('-')
                output?.text=zeroRemover(((-1*splitedarray[0].toDouble())-splitedarray[1].toDouble()).toString())}
               else if(val2.contains("+")){

                    val splitedarray=val2.split('+')
                    output?.text=zeroRemover(((-1*splitedarray[0].toDouble())+splitedarray[1].toDouble()).toString())}
                else if(val2.contains("*")){

                    val splitedarray=val2.split('*')
                    output?.text=zeroRemover(((-1*splitedarray[0].toDouble())*splitedarray[1].toDouble()).toString())}
                else if(val2.contains("/")){

                    val splitedarray=val2.split('/')
                    output?.text=zeroRemover(((-1*splitedarray[0].toDouble())/splitedarray[1].toDouble()).toString())}

            }




        }
    }
    fun zeroRemover(value:String):String
    {var ans:String=value
        if(value.contains(".0")){
         ans= value.substring(0,value.length-2)
        }
         return ans

    }
    fun OnclickButton(view: View){
        output?.append((view as Button).text)
        numberBefor=true
        decimalBefore=false


    }
    fun Clear(view:View){
        output?.text=" "

    }
    fun delete(view:View)
    { var txt:String=output?.text.toString()
        if(txt.length>0) {
            output?.text = txt.substring(0, txt.length - 1)

            if(txt.length-1==0)numberBefor=false
        }
        else numberBefor=false
    }
    fun DecimalPoint(view: View){
        if(numberBefor&&!decimalBefore) {
            output?.append((view as Button).text)
            decimalBefore=true
            numberBefor=false
        }
        }
    fun WhenOperatorPressed(view:View)
    {
        output?.text?.let{
if(numberBefor&&!isOperatorPressed(it.toString())){
    output?.append((view as Button).text)
    decimalBefore=false
    numberBefor=false
    }
        }

    }
    fun isOperatorPressed(view:String):Boolean
    {if(view.startsWith("-")){
return false
    }
        else if(view.contains("-")||view.contains("/")||view.contains("*")||view.contains("+")
        ||view.contains("=")){return false}

else return false
    }

    }
