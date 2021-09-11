package com.dicoding.popcorn.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dicoding.popcorn.R
import com.jaeger.library.StatusBarUtil

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        StatusBarUtil.setTransparent(this)

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, TIME_OUT)
    }

    companion object {
        private const val TIME_OUT: Long = 3000
    }
}