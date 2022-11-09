package com.umc.week_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.week_6.databinding.Fragment22Binding
import com.umc.week_6.databinding.Fragment33Binding

class Fragment33 : Fragment() {
    private lateinit var binding : Fragment33Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment33Binding.inflate(layoutInflater)

        return binding.root
    }
}