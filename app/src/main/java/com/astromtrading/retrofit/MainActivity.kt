package com.astromtrading.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin()
    }
    fun btnLogin(){
        val context=this
        var btnSubmit: Button =findViewById(R.id.btn_submit)
        var email: EditText =findViewById(R.id.username)
        var password: EditText =findViewById(R.id.password)
        btnSubmit.setOnClickListener{
            if(email.text.toString().equals("juan@gmail.com") && password.text.toString().equals("pass")){
                val intent = Intent(context,LoginSuccessful::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context,"Login incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}