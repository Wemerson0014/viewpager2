package com.estudo.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.estudo.viewpager2.adapter.WelcomeAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var welcomeAdapter: WelcomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)

        val contents = listOf(
            Welcome(
                getString(R.string.first_title),
                R.drawable.img_01,
                getString(R.string.first_description)
            ),
            Welcome(
                getString(R.string.second_title),
                R.drawable.img_02,
                getString(R.string.second_description)
            ),
            Welcome(
                getString(R.string.third_title),
                R.drawable.img_03,
                getString(R.string.third_description)
            ),
        )

        welcomeAdapter = WelcomeAdapter(this, contents)
        viewPager2.adapter = welcomeAdapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = "Página #${position + 1}"
        }.attach()

    }
}