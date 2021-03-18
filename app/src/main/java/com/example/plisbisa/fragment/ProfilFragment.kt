package com.example.plisbisa.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.plisbisa.MainActivity
import com.example.plisbisa.R
import com.example.plisbisa.activity.LoginActivity
import com.example.plisbisa.helper.SharedPrefe


class ProfilFragment : Fragment() {

    lateinit var s:SharedPrefe
    lateinit var btnLogout:TextView
    lateinit var tvNama:TextView
    lateinit var tvEmail:TextView
    lateinit var tvPhone:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profil, container, false)

        s = SharedPrefe(activity!!)

        init(view)

        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }

        setData()
        return view
    }

    private fun setData() {

        if (s.getUser() == null){
            val inten = Intent(activity, LoginActivity::class.java)
            inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(inten)
            return
        }

        val user = s.getUser()!!
        tvNama.text = user.name
        tvEmail.text = user.email
        tvPhone.text = user.phone

    }

    private fun init(view: View) {
        btnLogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

}