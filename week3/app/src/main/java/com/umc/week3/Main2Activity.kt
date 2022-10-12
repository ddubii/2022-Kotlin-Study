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

        //액티비티1로
        binding.gotoA1Btn.setOnClickListener {
            val intentA1 = Intent(this, MainActivity::class.java)
            intentA1.putExtra("string", "Back")
            startActivity(intentA1)
        }

        //액티비티3으로
        binding.gotoA3Btn.setOnClickListener {
            val intentA3 = Intent(this, Main3Activity::class.java)
            startActivity(intentA3)
        }

    }
}