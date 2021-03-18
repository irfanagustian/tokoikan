package com.example.plisbisa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.plisbisa.R
import com.example.plisbisa.helper.SharedPrefe
import kotlinx.android.synthetic.main.activity_baru.*

class BaruActivity : AppCompatActivity() {

    lateinit var s:SharedPrefe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baru)

        s = SharedPrefe(this)

        mainButton()

    }

    private fun mainButton(){
        btn_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        btn_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}