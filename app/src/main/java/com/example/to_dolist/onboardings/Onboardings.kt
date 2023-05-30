package com.example.to_dolist.onboardings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.to_dolist.R
import com.example.to_dolist.ViewPagerAdapter
import com.example.to_dolist.databinding.ActivityOnboardingsBinding

class Onboardings : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter
    }
}