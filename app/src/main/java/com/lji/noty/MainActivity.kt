package com.lji.noty

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Define ActionBar object
        // Define ActionBar object

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#FFFFFF"))

        // Set BackgroundDrawable

        // Set BackgroundDrawables
        supportActionBar?.setBackgroundDrawable(colorDrawable)
        supportActionBar?.title = Html.fromHtml(("<font color=\"black\">"+getString(R.string.app_name)+"</font>"))

    }
}