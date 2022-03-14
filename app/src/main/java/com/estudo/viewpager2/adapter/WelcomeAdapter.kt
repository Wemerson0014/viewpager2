package com.estudo.viewpager2.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.estudo.viewpager2.Welcome
import com.estudo.viewpager2.fragment.WelcomeFragment

class WelcomeAdapter(fa: FragmentActivity, private val contents: List<Welcome>) :
    FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return contents.size
    }

    override fun createFragment(position: Int): Fragment {
        return WelcomeFragment.newInstance(contents[position])
    }
}