package com.example.plisbisa.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.plisbisa.R
import com.example.plisbisa.helper.SharedPrefe


class ProfilFragment : Fragment() {

    lateinit var s:SharedPrefe
    lateinit var btnLogout:Button
 
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profil, container, false)

        btnLogout = view.findViewById(R.id.btn_logout)
        s = SharedPrefe(activity!!)

        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }

        return view
    }

}