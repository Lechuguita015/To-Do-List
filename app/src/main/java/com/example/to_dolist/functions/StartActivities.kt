package com.example.to_dolist.functions

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.to_dolist.Home
import com.example.to_dolist.onboardings.Onboardings

class StartActivities {
    private val context: Context

    constructor(context: Context) {
        this.context = context
    }
    fun startHome(){
        val intent = Intent(context, Home::class.java)
        context.startActivity(intent)
    }
    fun startOnboardings(){
        val intent = Intent(context, Onboardings::class.java)
        context.startActivity(intent)
    }

}