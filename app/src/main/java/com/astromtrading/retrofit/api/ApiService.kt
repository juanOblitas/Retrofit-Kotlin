package com.astromtrading.retrofit.api

import com.astromtrading.retrofit.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {


    
    
    companion object {
        //val BASE_URL = "http://127.0.0.1:8001";
        //val BASE_URL = "http://192.168.56.1:8001"
        val BASE_URL = "http://10.0.2.2:8001/api/"
        //val BASE_URL = "http://192.168.1.33:8001"
        //val BASE_URL = "http://10.0.2.2:8001"
    }

    @get:GET("user/all")
    val allUsers: Call<List<User>>

    @POST("user/save")
    fun saveUser(@Body user: User): Call<User>

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
