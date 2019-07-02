package com.jk.mytaxi.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jk.mytaxi.R
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

}
