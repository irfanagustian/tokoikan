package com.example.plisbisa.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.plisbisa.MainActivity
import com.example.plisbisa.R
import com.example.plisbisa.app.ApiConfig
import com.example.plisbisa.helper.SharedPrefe
import com.example.plisbisa.model.ResponModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.edt_email
import kotlinx.android.synthetic.main.activity_register.edt_password
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var s: SharedPrefe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener {
            register()
        }
    }

    private fun register(){
        if (edt_nama.text.isEmpty()){
            edt_nama.error = "kolom nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        }else if (edt_email.text.isEmpty()){
            edt_email.error = "kolom e-mail tidak boleh kosong"
            edt_email.requestFocus()
            return
        }else if (edt_phone.text.isEmpty()){
            edt_phone.error = "kolom telepon tidak boleh kosong"
            edt_phone.requestFocus()
            return
        }else if (edt_password.text.isEmpty()){
            edt_password.error = "kolom password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        pb_register.visibility =View.VISIBLE
        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(), edt_email.text.toString(), edt_phone.text.toString(), edt_password.text.toString()).
                enqueue(object : Callback<ResponModel>{
                    override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                        pb_register.visibility =View.GONE
                        val respon = response.body()!!

                        if (respon.success==1){
                            Toast.makeText(this@RegisterActivity, "Akun Berhasil Dibuat Silahkan Melakukan login", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@RegisterActivity, "Error: "+respon.message,
                                    Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                        pb_register.visibility =View.GONE
                        Toast.makeText(this@RegisterActivity, "Error: "+t.message,
                        Toast.LENGTH_SHORT).show()
                    }

                })
    }

}