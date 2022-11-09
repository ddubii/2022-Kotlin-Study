package com.umc.week5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.umc.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        Log.d("Life Cycle", "onCreate")

        val dataList: ArrayList<Data> = arrayListOf()


        dataList.apply {
            add(Data("hello"))
            add(Data("hello"))
            add(Data("hello"))
        }
        val dataRVAdapter = DataRVAdapter(dataList)

        viewBinding.rvData.adapter = dataRVAdapter
        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        if (intent.hasExtra("NewMemo")) {
            val data1 = intent.getStringExtra("NewMemo")
            dataList.add(Data("${data1.toString()}"))
        }
        dataRVAdapter.notifyItemInserted(dataList.size)

        viewBinding.addMemoBtn.setOnClickListener {
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)
        }

        fun getItemViewType(position: Int): Int {
            return position
        }
    }
}
