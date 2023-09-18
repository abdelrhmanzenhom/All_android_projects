package com.example.quezapp

object Constants {
    const val USER_NAME:String="user name"
    const val TOTAL_QUESTIONS:String="total questions"
    const val CORRECT_ANS:String="correct answers"

    fun AddQustions():ArrayList<Queston>{
        val Questionlist=ArrayList<Queston>()
       val queston1=Queston(1,"what country flag is this",R.drawable.ic_flag_of_argentina
       ,"Argentena","egypt","iraq","brazil",1)
        val queston2=Queston(2,"what country flag is this",R.drawable.ic_flag_of_australia
            ,"Argentena","australia","iraq","brazil",2)
        val queston3=Queston(3,"what country flag is this",R.drawable.ic_flag_of_belgium
            ,"Argentena","egypt","belgium","brazil",3)
        val queston4=Queston(4,"what country flag is this",R.drawable.ic_flag_of_brazil
            ,"Argentena","egypt","iraq","brazil",4)
        val queston5=Queston(5,"what country flag is this",R.drawable.ic_flag_of_denmark
            ,"Argentena","denmark","iraq","brazil",2)
        val queston6=Queston(6,"what country flag is this",R.drawable.ic_flag_of_germany
            ,"Argentena","egypt","germany","brazil",3)
        val queston7=Queston(7,"what country flag is this",R.drawable.ic_flag_of_india
            ,"Argentena","egypt","iraq","india",4)
        val queston8=Queston(8,"what country flag is this",R.drawable.ic_flag_of_kuwait
            ,"kuwait","egypt","iraq","brazil",1)
        val queston9=Queston(9,"what country flag is this",R.drawable.ic_flag_of_new_zealand
            ,"Argentena","egypt","iraq","new_zealand",4)
        val queston10=Queston(10,"what country flag is this",R.drawable.ic_flag_of_fiji
            ,"Argentena","egypt","iraq","brazil",2)
        Questionlist.add(queston1)
        Questionlist.add(queston2)
        Questionlist.add(queston3)
        Questionlist.add(queston4)
        Questionlist.add(queston5)
        Questionlist.add(queston6)
        Questionlist.add(queston7)
        Questionlist.add(queston8)
        Questionlist.add(queston9)


        return Questionlist
    }
}