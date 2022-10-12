package com.umc.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umc.week3.databinding.ActivityMain3Binding
import com.umc.week3.fragments.Fragment1
import com.umc.week3.fragments.Fragment2

class Main3Activity : AppCompatActivity() {
    private lateinit var binding : ActivityMain3Binding
    lateinit var f1: Fragment1
    lateinit var f2: Fragment2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //  switch to fragment1
        binding.btn1.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.frameFragment.id, Fragment1())
                .commitAllowingStateLoss()
        }

        //  switch to fragment2
        binding.btn2.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(binding.frameFragment.id, Fragment2())
                .commitAllowingStateLoss()
        }

        supportFragmentManager
            .setFragmentResultListener("requestKey", this) { requestKey, bundle ->
                val result = bundle.getString("bundleKey")
                Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show()
            }

    }
}