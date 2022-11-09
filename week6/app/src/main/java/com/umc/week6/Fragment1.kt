package com.umc.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.umc.week6.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding : Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = Fragment1Binding.inflate(layoutInflater)

        binding.Fragment2ActivityBtn.setOnClickListener {
            val result = binding.FragmentEdittext.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }


        return binding.root
    }
}
