package com.hb.week2.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hb.week2.R
import com.hb.week2.databinding.FragmentOtherBinding

class OtherFragment : Fragment() {
    private lateinit var binding : FragmentOtherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.PayTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_otherFragment_to_payFragment)
        }
        binding.OrderTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_otherFragment_to_orderFragment)
        }
        return binding.root
    }

}