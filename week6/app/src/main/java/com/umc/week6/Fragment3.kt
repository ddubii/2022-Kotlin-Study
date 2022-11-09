package com.umc.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.week6.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private lateinit var binding : Fragment3Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment3Binding.inflate(layoutInflater)

        return binding.root
    }
}