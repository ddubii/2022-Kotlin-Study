package com.umc.week_6

import android.net.VpnManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.umc.week_6.databinding.Fragment1Binding
import com.umc.week_6.databinding.Fragment2Binding

class Fragment1 : Fragment()  {
    private lateinit var binding : Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment1Binding.inflate(layoutInflater)

        val vpadapter = VPAdapter(this)
        binding.vpF1.adapter = vpadapter

        val tabName = arrayOf(
            "One", "Two", "Three"
        )
        TabLayoutMediator(binding.tabF1, binding.vpF1) {tab, position ->
            tab.text = tabName[position]
        }.attach()
        return binding.root
    }
}