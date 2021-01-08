package com.astromtrading.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.astromtrading.retrofit.api.ApiService
import com.astromtrading.retrofit.api.ApiUtils
import com.astromtrading.retrofit.model.User
import org.mindrot.jbcrypt.BCrypt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_user)
        saveUser()
    }
    fun saveUser(){
        val context=this
        var btnSaveUser: Button =findViewById(R.id.btn_save_user)
        var inputName: EditText =findViewById(R.id.input_name)
        var inputEmail: EditText =findViewById(R.id.input_email)
        var inputPassword: EditText =findViewById(R.id.input_password)
        var inputConfirmPassword: EditText =findViewById(R.id.input_confirm_password)

        btnSaveUser.setOnClickListener{
            //Guardamos el usuario, verificando que los campos sean correctos
            if(inputName.text.toString().isNotBlank() && inputEmail.text.toString().isNotBlank() &&
                    inputPassword.text.toString().isNotBlank() && inputConfirmPassword.text.toString().isNotBlank()
                    && inputPassword.text.toString().equals(inputConfirmPassword.text.toString())){
                //Guardamos
                    /*No encriptamos password ya que laravel ya lo hace por nosotros
                val passwordEncript= BCrypt.checkpw(inputPassword.toString(),"password")
                val user:User=User(inputName.toString(),inputEmail.toString(),passwordEncript.toString())*/
                val user:User=User(inputName.text.toString(),inputEmail.text.toString(),inputPassword.text.toString())
                val apiService : ApiService = ApiUtils().getAPIService()
                apiService.saveUser(user).enqueue(object : Callback<User?> {
                    override fun onResponse(call: Call<User?>, response: Response<User?>) {
                        if (response.isSuccessful) {
                            var myUser: User? = response.body()
                            val intent = Intent(context, GetAllUsers::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(context,"Falla al agregar usuario",Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<User?>, t: Throwable) {
                        println("fallo en la llamada. Error:" + t.printStackTrace())
                    }
                })

            }else{
                val intent = Intent(context,FormUser::class.java)
                startActivity(intent)
            }
        }
    }
}