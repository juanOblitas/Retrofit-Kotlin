package com.astromtrading.retrofit.model

import com.google.gson.annotations.SerializedName

class User (@SerializedName("id") val id:Long, @SerializedName("name") var name:String,
            @SerializedName("email") var email:String, @SerializedName("password") var password:String){

}