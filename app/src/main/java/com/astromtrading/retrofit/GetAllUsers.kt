package com.astromtrading.retrofit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.astromtrading.retrofit.api.ApiService
import com.astromtrading.retrofit.api.ApiUtils
import com.astromtrading.retrofit.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetAllUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_users)
        getUsers()
    }

    fun getUsers() {
        /*Se comenta esto porque se ha creado clases RetrofitClient y ApiUtils para resumir
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService : ApiService = retrofit.create(ApiService::class.java)*/
        var context=this
        val apiService : ApiService = ApiUtils().getAPIService()
        var myUsers: Call<List<User>> = apiService.allUsers
        var descriptionUser:String ="";
        //var viewUsers: TextView =findViewById(R.id.allusers)
        var listViewUser: ListView=findViewById(R.id.listViewUsers)
        myUsers.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                var users: List<User>? = response.body()
                /*
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                val users: UserList? = gson.fromJson(response.body(), UserList::class.java)*/
                var listItems = ArrayList<String>()
                if (users != null && !users.isEmpty()) {
                    users.forEach {
                        //descriptionUser += it.name + " " + it.email
                        listItems.add(it.name + " " + it.email)
                    }
                } else {
                    descriptionUser = "No hay usuarios"
                }

                val adapter = ArrayAdapter(context,
                        android.R.layout.simple_list_item_1,
                        listItems)

                listViewUser.setAdapter(adapter)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                descriptionUser = "fallo en la llamada. Error:" + t.printStackTrace()
                //viewUsers.setText(descriptionUser)
            }
        })

    }
}