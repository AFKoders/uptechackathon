package com.afkoders.uptechackathon.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.afkoders.uptechackathon.R
import dagger.android.support.DaggerAppCompatActivity


class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        /*with(window) {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            statusBarColor = Color.TRANSPARENT
        }*/

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object{
        const val NOTIFICATION_INTENT = "NOTIFICATION_INTENT"
    }
}
