package com.umc.week3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.week3.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding : Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment1Binding.inflate(layoutInflater)

        return binding.root
    }
}
