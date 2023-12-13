package com.example.drawingapp

import android.content.Context
import android.graphics.*
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class DrawingView(context:Context,attr:AttributeSet) : View(context,attr) {
    private var DrawPath:CustomPath?=null
    private var Canvasbitmap:Bitmap?=null
    private var DrawPaint: Paint?=null
    private var Canvasepaint:Paint?=null
    private var Brushsize:Float=0.toFloat()
    private var color = Color.BLACK
    private var canvas:Canvas?=null
    private var paths=ArrayList<CustomPath>()
    init{
        setupDrawing()
    }
    private fun setupDrawing()
    {
        DrawPaint=Paint()
        DrawPath=CustomPath(color,Brushsize)
        DrawPaint!!.color=color
        DrawPaint!!.style=Paint.Style.STROKE
        DrawPaint!!.strokeJoin=Paint.Join.ROUND
        DrawPaint!!.strokeCap=Paint.Cap.ROUND
        Canvasepaint=Paint(Paint.DITHER_FLAG)
        //Brushsize=20.toFloat()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Canvasbitmap=Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        canvas=Canvas(Canvasbitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(Canvasbitmap!!,0F,0F,Canvasepaint)
        for(path in paths){
            DrawPaint!!.strokeWidth=path!!.brushthikness
            DrawPaint!!.color=path!!.color
            canvas.drawPath(path!!,DrawPaint!!)
        }
        if(!DrawPath!!.isEmpty) {DrawPaint!!.strokeWidth=DrawPath!!.brushthikness
            DrawPaint!!.color=DrawPath!!.color
            canvas.drawPath(DrawPath!!,DrawPaint!!)}
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchx=event?.x
        val touchy=event?.y
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                DrawPath!!.color=color
                DrawPath!!.brushthikness=Brushsize
                DrawPath!!.reset()
                DrawPath!!.moveTo(touchx!!,touchy!!)
            }
            MotionEvent.ACTION_MOVE->{
                DrawPath!!.lineTo(touchx!!,touchy!!)
            }
            MotionEvent.ACTION_UP->{
                paths.add(DrawPath!!)
                DrawPath=CustomPath(color, Brushsize)
            }
            else -> return false

        }
        invalidate()
        return true

    }
    fun setSizeForBrush(newSize: Float) {
        Brushsize = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, newSize,
            resources.displayMetrics
        )
        DrawPaint?.strokeWidth = Brushsize
    }
    fun setColor(newcolor:String)
    {
        color=Color.parseColor(newcolor)
        DrawPaint!!.color=color

    }
    internal inner class CustomPath(var color:Int,var brushthikness:Float): Path() {


    }
}