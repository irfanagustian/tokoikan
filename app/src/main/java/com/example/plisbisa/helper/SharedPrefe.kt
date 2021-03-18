package com.example.plisbisa.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPrefe(activity: Activity) {

    val statLogin = "Login"
    val myPrefe = "MY_PREFE"
    val sp:SharedPreferences

    init {
        sp = activity.getSharedPreferences(myPrefe, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(statLogin, status).apply()
    }

    fun getStatusLogin(): Boolean{
        return sp.getBoolean(statLogin, false)
    }
}