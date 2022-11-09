package com.umc.week_6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(fragment1: Fragment1):FragmentStateAdapter(fragment1) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Fragment11()
            1 -> Fragment22()
            2 -> Fragment33()
            else -> Fragment11()
    }
    }
}