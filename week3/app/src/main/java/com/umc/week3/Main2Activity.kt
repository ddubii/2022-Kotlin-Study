package com.umc.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umc.week3.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("text")) {
            binding.textview.text = intent.getStringExtra("text")
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}