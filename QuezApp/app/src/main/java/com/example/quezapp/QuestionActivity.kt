package com.example.quezapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuestionActivity : AppCompatActivity() , View.OnClickListener{
    private var CurrentPosition:Int=1
    private var coreectAnswers:Int=0
    private var QustionList:ArrayList<Queston>?=null
    private var SelectedOption:Int=0
    private var UserName:String?=null
    private var progressbar:ProgressBar?=null
    private var op1:TextView?=null
    private var op2:TextView?=null
    private var op3:TextView?=null
    private var op4:TextView?=null
    private var flageImage:ImageView?=null
    private var submetingBt: Button?=null
    private var progressTV:TextView?=null
    private var questionTV:TextView?=null
    private var buttSubmet:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        progressbar=findViewById(R.id.progressBar)
        op1=findViewById(R.id.OP1)
        op2=findViewById(R.id.OP2)
        op3=findViewById(R.id.OP3)
        op4=findViewById(R.id.OP4)
        flageImage=findViewById(R.id.flagImage)
        submetingBt=findViewById(R.id.submetBt)
        progressTV=findViewById(R.id.numberofquestions)
        questionTV=findViewById(R.id.questionTV)
        buttSubmet=findViewById(R.id.submetBt)
        UserName=intent.getStringExtra(Constants.USER_NAME)
         QustionList = Constants.AddQustions()
        SetQuestion()


    }

    private fun SetQuestion() {
        defaultOptionsView()
        val question: Queston = QustionList!![CurrentPosition - 1]
        questionTV?.text = question.question
        progressbar?.progress = CurrentPosition
        progressTV?.text = "$CurrentPosition/${progressbar?.max}"
        op1?.text = question.option1
        op2?.text = question.option2
        op3?.text = question.option3
        op4?.text = question.option4
        op1?.setOnClickListener(this)
        op2?.setOnClickListener(this)
        op3?.setOnClickListener(this)
        op4?.setOnClickListener(this)
        buttSubmet?.setOnClickListener(this)
        flageImage?.setImageResource(question.image)
        if(CurrentPosition==QustionList!!.size)
        {
            buttSubmet?.text="FINISH"
        }
        else {
            buttSubmet?.text="SUBMIT"
        }
    }
    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        op1?.let{
            options.add(0,it)
        }
        op2?.let{
            options.add(1,it)
        }
        op3?.let{
            options.add(2,it)
        }
        op4?.let{
            options.add(3,it)
        }
        for(option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,R.drawable.questionrectangle
            )
        }
    }
    private fun selectedOptionView(textView: TextView,selectedOptionNum:Int)
    {defaultOptionsView()
        SelectedOption=selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background=ContextCompat.getDrawable(
            this,R.drawable.selected_question_bg)


    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.OP1 -> {
                op1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.OP2 -> {
                op2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.OP3 -> {
                op3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.OP4 -> {
                op4?.let {
                    selectedOptionView(it, 4)
                }

            }
            R.id.submetBt-> {
                if (SelectedOption == 0) {
                    CurrentPosition++
                    when {
                        CurrentPosition <= QustionList!!.size -> {SetQuestion()}
                        else->{
                            val intent= Intent(this,ResulteActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,UserName)
                            intent.putExtra(Constants.CORRECT_ANS,coreectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,QustionList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }


                }
                else{
                    val queston=QustionList?.get(CurrentPosition-1)
                    if(queston!!.correctOp!=SelectedOption)
                    {
                        AnswerView(SelectedOption,R.drawable.wrongquestionrectangle)
                    }
                    else{coreectAnswers++}
                    AnswerView(queston!!.correctOp,R.drawable.correctquestionrectangle)
                    if(CurrentPosition==QustionList!!.size)
                        buttSubmet?.text="FINISH"
                    else {buttSubmet?.text="GO TO THE NEXT QUESTION"
                    }
                    SelectedOption=0;
                }

            }
        }
    }
    private fun AnswerView(answer:Int,drawable:Int){
        when(answer){
            1-> {
                op1?.background=ContextCompat.getDrawable(this,drawable)
            }
            2-> {
                op2?.background=ContextCompat.getDrawable(this,drawable)
            }
            3-> {
                op3?.background=ContextCompat.getDrawable(this,drawable)
            }
            4-> {
                op4?.background=ContextCompat.getDrawable(this,drawable)
            }
        }

    }
}