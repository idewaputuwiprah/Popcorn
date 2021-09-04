package com.idputuwiprah.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.popcorn.databinding.ActivityHomeBinding
import com.jaeger.library.StatusBarUtil

class FavoriteActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        StatusBarUtil.setTransparent(this)

        val sectionPagerFavoriteAdapter = SectionPagerFavoriteAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionPagerFavoriteAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)

        activityMainBinding.fabFav.visibility = View.GONE
    }
}