package com.example.to_dolist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.to_dolist.functions.StartActivities
import com.example.to_dolist.onboardings.Onboardings

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            if(onBoardingFinish()){
                val home = StartActivities(this)
                home.startHome()
            }else {
                val onBoard = StartActivities(this)
                onBoard.startOnboardings()
            }
        },3000)
    }
    private fun onBoardingFinish():Boolean{
        val sharedPref = getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("finish", false)
    }
}