package com.umc.week4

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.umc.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var TempMemo : String
    private lateinit var TempTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //저장 버튼을 누를 경우
        binding.button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("title", binding.editTitle.text.toString())
            intent.putExtra("memo", binding.editMemo.text.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        TempTitle = binding.editTitle.text.toString()
        TempMemo = binding.editMemo.text.toString()
        binding.editTitle.text = null
        binding.editMemo.text = null
    }

    override fun onRestart() {
        super.onRestart()
        // 기본 형태의 다이얼로그

        val builder = AlertDialog.Builder(this)
        builder.setTitle("알림")
            .setMessage("메모를 이어서 작성하시겠습니까?")
            .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    binding.editTitle.setText("$TempTitle")
                    binding.editMemo.setText("$TempMemo")
                })
            .setNegativeButton("취소",
                DialogInterface.OnClickListener { dialog, id ->
                    TempTitle = null.toString()
                    TempMemo = null.toString()
                    binding.editTitle.text = null
                    binding.editMemo.text = null
                })
        // 다이얼로그를 띄워주기
        builder.show()

    }

}