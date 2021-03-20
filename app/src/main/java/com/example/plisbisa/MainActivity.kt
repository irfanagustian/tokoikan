package com.example.plisbisa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.plisbisa.activity.LoginActivity
import com.example.plisbisa.fragment.HomeFragment
import com.example.plisbisa.fragment.ProfilFragment
import com.example.plisbisa.helper.SharedPrefe
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var statusLogin = false
    private lateinit  var s:SharedPrefe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPrefe(this)

        btm_navigation.setOnNavigationItemSelectedListener(onBottomNavigationView)
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fm_layout, HomeFragment())
        fragment.commit()
    }

    private val onBottomNavigationView = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment : Fragment = HomeFragment()

        when(item.itemId) {
            R.id.item_home -> {
                selectedFragment = HomeFragment()
            }
            R.id.item_profil -> {
                if(s.getStatusLogin()){
                    selectedFragment = ProfilFragment()
                } else{
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }

        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fm_layout, selectedFragment)
        fragment.commit()
        true

    }
}