package com.example.plisbisa.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plisbisa.MainActivity
import com.example.plisbisa.R
import com.example.plisbisa.app.ApiConfig
import com.example.plisbisa.model.ResponModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edt_email
import kotlinx.android.synthetic.main.activity_login.edt_password
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.plisbisa.helper.SharedPrefe



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            login()
        }
    }

    fun login(){
        if (edt_email.text.isEmpty()){
            edt_email.error = "kolom e-mail tidak boleh kosong"
            edt_email.requestFocus()
            return
        }else if (edt_password.text.isEmpty()){
            edt_password.error = "kolom password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        pb_login.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.login(edt_email.text.toString(), edt_password.text.toString()).
        enqueue(object : Callback<ResponModel> {
            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                pb_login.visibility = View.GONE
                val respon = response.body()!!

                if (respon.sucsess==1){
                    val s = SharedPrefe(this@LoginActivity)
                    s.setStatusLogin(true)
                    s.setUser(respon.user)
//                    s.setString(s.nama, respon.user.name)
//                    s.setString(s.email, respon.user.email)
//                    s.setString(s.phone, respon.user.phone)

                    val inten = Intent(this@LoginActivity, MainActivity::class.java)
                    inten.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(inten)
                    finish()

                    Toast.makeText(this@LoginActivity, "Selamat Datang "+
                            respon.user.name, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@LoginActivity, "Error: "+respon.message,
                            Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                pb_login.visibility = View.GONE
                Toast.makeText(this@LoginActivity, "Error: "+t.message,
                        Toast.LENGTH_SHORT).show()
            }

        })
    }
}