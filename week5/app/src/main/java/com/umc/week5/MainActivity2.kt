package com.umc.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.week5.databinding.ActivityMain2Binding
import com.umc.week5.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val dataList: ArrayList<Data> = arrayListOf()

        viewBinding.saveMemoBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NewMemo", viewBinding.editMemo.text.toString())
            startActivity(intent)
            finish()
    }

    fun getItemViewType(position: Int): Int {
        return position
    }
}}