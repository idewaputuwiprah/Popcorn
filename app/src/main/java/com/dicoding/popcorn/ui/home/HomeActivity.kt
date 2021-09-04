package com.dicoding.popcorn.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.popcorn.databinding.ActivityHomeBinding
import com.jaeger.library.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        activityMainBinding.fabFav.setOnClickListener {
            val intent = Intent(this, Class.forName("com.idputuwiprah.favorite.FavoriteActivity"))
            startActivity(intent)
        }
    }
}