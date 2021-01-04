package com.astromtrading.retrofit

import com.astromtrading.retrofit.model.User
import com.astromtrading.retrofit.model.UserList

import retrofit2.Call
import retrofit2.http.GET

interface Api {


    
    
    companion object {
        //val BASE_URL = "http://127.0.0.1:8001";
        //val BASE_URL = "http://192.168.56.1:8001"
        val BASE_URL = "http://10.0.2.2:8001/api/"
        //val BASE_URL = "http://192.168.1.33:8001"

        //val BASE_URL = "http://10.0.2.2:8001"
        //192.168.56.1
    }

    @get:GET("user/all")
    val allUsers: Call<List<User>>
    /*
    @GET("onomastica/v1/noms/{name}.json")
    Call<Onomastica>getDades(@Path("name") String name);

    @GET("onomastica/v1/noms/carlos.json")
    Call<Onomastica>getDade();

    @GET("onomastica/v1/noms/{name}.json")
    Call<Onomastica>getRankingAndPosition(@Path("name") String name);*/
    /*@GET("/")
    Call<Search> getAllMovies(@Query("s") String title, @Query("apikey") String apikey);*/
}
