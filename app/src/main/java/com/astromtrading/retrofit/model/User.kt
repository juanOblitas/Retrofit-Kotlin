package com.astromtrading.retrofit.model

import com.google.gson.annotations.SerializedName
/*
class User (@SerializedName("id") val id:Long, @SerializedName("name") var name:String,
            @SerializedName("email") var email:String, @SerializedName("password") var password:String){
}*/
class User{
    @SerializedName("id") val id:Long
    @SerializedName("name") var name:String
    @SerializedName("email") var email:String
    @SerializedName("password") var password:String
    constructor(id: Long, name: String, email: String, password: String) {
        this.id = id
        this.name = name
        this.email=email
        this.password=password
    }
    constructor(name: String, email: String, password: String){
        this.id=0
        this.name = name
        this.email=email
        this.password=password
    }
}
