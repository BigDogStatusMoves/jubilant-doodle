package com.example.skuta.gesturesassignment

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import org.w3c.dom.Text
import android.widget.Toast.makeText as makeText

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    lateinit var button: ImageView
    lateinit var layout: ConstraintLayout
    lateinit var flingText: TextView
   var movement: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.constraint_layout)
        layout.setBackgroundColor(Color.WHITE)
        movement = GestureDetectorCompat(this,this)
        flingText = findViewById(R.id.fling_text)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        movement?.onTouchEvent(event!!)
        return true
    }

    override fun onDown(e: MotionEvent): Boolean {
        return true
    }


    override fun onShowPress(e: MotionEvent) {
        flingText.text = ""
        makeText(this,"You pressed the button!",LENGTH_SHORT).show()
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        flingText.text = "We do a little scrolling"
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        makeText(this, "You're pressing for a long time!", LENGTH_LONG).show()
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, p2: Float, p3: Float): Boolean {
        flingText.text = "weeeeeeeeee"
        makeText(this,"You flung...something.", LENGTH_LONG).show()
        return true
    }
}