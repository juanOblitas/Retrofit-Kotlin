package com.astromtrading.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginSuccessful : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_successful)
        getAllUsers()
    }
    fun getAllUsers(){
        val context=this
        var btnAllUsers: Button =findViewById(R.id.btn_all_users)
        var btnUserForm: Button =findViewById(R.id.btn_user_form)
        btnAllUsers.setOnClickListener{
            val intent = Intent(context,GetAllUsers::class.java)
            startActivity(intent)
        }
        btnUserForm.setOnClickListener{
            val intent = Intent(context,FormUser::class.java)
            startActivity(intent)
        }
    }
}