package com.umc.week_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umc.week_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewbinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewbinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewbinding.containerLayout.id, Fragment1())
            .commitAllowingStateLoss()

        viewbinding.navBottom.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_1 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerLayout.id, Fragment1())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_2 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerLayout.id, Fragment2())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_3 -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewbinding.containerLayout.id, Fragment3())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_1
        }
    }}
