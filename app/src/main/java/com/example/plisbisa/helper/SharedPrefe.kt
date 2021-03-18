package com.example.plisbisa.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.plisbisa.model.User
import com.google.gson.Gson

class SharedPrefe(activity: Activity) {

    val user = "user"
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

    fun setUser(value: User){
        val data = Gson().toJson(value, User::class.java)
        sp.edit().putString(user, data).apply()
    }

    fun getUser():User?{
        val data = sp.getString(user, null)?: return null
        return Gson().fromJson<User>(data, User::class.java)
    }

}