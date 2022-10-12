package com.umc.week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.umc.week3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("string")) {
            val toastMsg = intent.getStringExtra("string")
            Toast.makeText(applicationContext, toastMsg, Toast.LENGTH_LONG).show()
        }

        //엑티비티1의 버튼을 누를 경우
        binding.button.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("text", binding.edittext.text.toString())
            startActivity(intent)
        }
    }
}