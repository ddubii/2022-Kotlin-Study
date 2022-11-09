package com.umc.week_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.week_6.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var binding : Fragment2Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment2Binding.inflate(layoutInflater)

        return binding.root
    }
}