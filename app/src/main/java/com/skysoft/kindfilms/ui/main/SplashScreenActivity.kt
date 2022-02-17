package com.skysoft.kindfilms.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.core.text.buildSpannedString
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.ActivityMainBinding
import com.skysoft.kindfilms.ui.main.MainActivity
import java.util.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
    }

    override fun onResume() {
        super.onResume()
        timer = Timer()
        timer.schedule(RemindTask(this), 3000)
    }

    fun startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intent)
    }

    class RemindTask (splashScreenActivity: SplashScreenActivity): TimerTask() {
        private lateinit var splashScreenActivity: SplashScreenActivity
        init {
            this.splashScreenActivity = splashScreenActivity
        }
        override fun run() {
            splashScreenActivity.startMainActivity()
        }
    }
}