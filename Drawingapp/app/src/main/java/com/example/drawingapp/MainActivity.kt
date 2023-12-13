package com.example.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var drawingView:DrawingView?=null
    private var selectedcolor:ImageButton?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val laniearlayout= findViewById<LinearLayout>(R.id.llForcolors)
        selectedcolor=laniearlayout[2] as ImageButton
        selectedcolor!!.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pallet_selected))
        drawingView=findViewById(R.id.drawing_view)
drawingView?.setSizeForBrush(20.toFloat())
        val brush: ImageButton =findViewById(R.id.imageButton)
        brush.setOnClickListener{
            showbrushsizeDialoge()
        }
    }
    fun paintclicked(view:View)
    {
        if(view !== selectedcolor){
            val  imagebutton= view as ImageButton
            val colortag= imagebutton.tag.toString()

            drawingView?.setColor(colortag)

            imagebutton.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pallet_selected))

            selectedcolor?.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.pallet_norm))

        selectedcolor=view
        }

    }
    private fun showbrushsizeDialoge()
    {
        var brushDialog=Dialog(this)
        brushDialog.setContentView(R.layout.brush_size)
        brushDialog.setTitle("Brush size: ")

        val smallBtn:ImageButton = brushDialog.findViewById<ImageButton>(R.id.ib_small_Brush)
        smallBtn.setOnClickListener{
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val midBtn:ImageButton = brushDialog.findViewById<ImageButton>(R.id.meduime_brush)
        midBtn.setOnClickListener{
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        val largeBtn:ImageButton = brushDialog.findViewById<ImageButton>(R.id.large_brush)
        largeBtn.setOnClickListener{
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()

    }
}