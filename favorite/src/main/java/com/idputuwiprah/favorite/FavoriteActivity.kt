package com.idputuwiprah.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import com.dicoding.popcorn.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.jaeger.library.StatusBarUtil

class FavoriteActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        StatusBarUtil.setTransparent(this)

        val sectionPagerFavoriteAdapter = SectionPagerFavoriteAdapter(this, supportFragmentManager, lifecycle)
        activityMainBinding.viewPager.adapter = sectionPagerFavoriteAdapter
        TabLayoutMediator(activityMainBinding.tabs, activityMainBinding.viewPager) {tabs, position->
            tabs.text = sectionPagerFavoriteAdapter.getPageTitle(position)
        }.attach()

        activityMainBinding.fabFav.visibility = View.GONE
    }
}