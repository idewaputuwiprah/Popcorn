package com.dicoding.popcorn.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.popcorn.databinding.ActivityHomeBinding
import com.jaeger.library.StatusBarUtil

class HomeActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        StatusBarUtil.setTransparent(this)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)
    }
}