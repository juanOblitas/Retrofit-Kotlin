package com.astromtrading.retrofit.model

import com.google.gson.annotations.SerializedName

abstract class UserList (@SerializedName("users") var users:List<User>) {

}