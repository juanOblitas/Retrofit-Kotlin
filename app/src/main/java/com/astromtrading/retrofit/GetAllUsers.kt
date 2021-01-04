package com.astromtrading.retrofit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.astromtrading.retrofit.model.User
import com.astromtrading.retrofit.model.UserList
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GetAllUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_users)
        getUsers()
    }

    fun getUsers() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api : Api = retrofit.create(Api::class.java)
        var myUsers: Call<List<User>> = api.allUsers
        var descriptionUser:String ="";
        var viewUsers: TextView =findViewById(R.id.allusers)
        myUsers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                var users: List<User>? = response.body()
                /*
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                val users: UserList? = gson.fromJson(response.body(), UserList::class.java)*/
                if (users != null && !users.isEmpty()) {
                    users.forEach{
                        descriptionUser+=it.name+" "+it.email
                    }
                } else {
                    descriptionUser = "No hay usuarios"
                }
                viewUsers.setText(descriptionUser)
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                descriptionUser = "fallo en la llamada. Error:" + t.printStackTrace()
                viewUsers.setText(descriptionUser)
            }
        })

    }
}