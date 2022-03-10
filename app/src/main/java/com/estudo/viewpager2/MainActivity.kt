package com.estudo.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estudo.viewpager2.fragment.WelcomeFragment
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        var contentIndex = 0

        replaceFragment(contents, contentIndex)

        val prevButton: MaterialButton = findViewById<MaterialButton>(R.id.btn_prev)
        val nextButton: MaterialButton = findViewById<MaterialButton>(R.id.btn_next)

        prevButton.isEnabled = false

        prevButton.setOnClickListener {
            if (contentIndex > 0) {
                contentIndex--

                replaceFragment(contents, contentIndex)

                if (contentIndex == 0) {
                    prevButton.isEnabled = false
                }
                if (contentIndex == contents.size - 2) {
                    nextButton.isEnabled = true
                }
            }
        }

        nextButton.setOnClickListener {
            if (contentIndex < contents.size - 1) {
                contentIndex++

                replaceFragment(contents, contentIndex)

                if (contentIndex == contents.size - 1) {
                    nextButton.isEnabled = false
                }
                if (contentIndex == 1) {
                    prevButton.isEnabled = true
                }
            }
        }
    }

    private fun replaceFragment(contents: List<Welcome>, contentIndex: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, WelcomeFragment.newInstance(contents[contentIndex]))
            .commit()
    }

}