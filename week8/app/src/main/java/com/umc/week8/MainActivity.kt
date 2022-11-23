package com.umc.week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.umc.week8.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private val binding: ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.containerLayout.id, MainFragment())
            .commitAllowingStateLoss()

    }
    fun changeFragment(index: Int){
        when(index){
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(binding.containerLayout.id, MainFragment())
                    .commit()
            }

            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(binding.containerLayout.id, WriteFragment())
                    .commit()
            }
        }
    }
}