package com.estudo.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudo.viewpager2.fragment.WelcomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contents = listOf(
            Welcome(
                getString(R.string.first_title),
                R.drawable.img_01,
                getString(R.string.description)
            ),
            Welcome(
                getString(R.string.second_title),
                R.drawable.img_02,
                getString(R.string.description)
        ),
            Welcome(
                getString(R.string.third_title),
                R.drawable.img_03,
                getString(R.string.description)
            )
        )

        val contentIndex = 0
        val fragment = WelcomeFragment.newInstance(contents[contentIndex])

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}