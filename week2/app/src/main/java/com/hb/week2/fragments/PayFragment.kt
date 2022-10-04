package com.hb.week2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.hb.week2.R
import com.hb.week2.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    private lateinit var binding : FragmentPayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.OtherTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_payFragment_to_otherFragment)
        }
        binding.OrderTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_payFragment_to_orderFragment)
        }
        return binding.root
    }

}