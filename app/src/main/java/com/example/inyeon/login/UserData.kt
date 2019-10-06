package com.example.inyeon

import com.example.inyeon.server.RetrofitConfig
import com.google.gson.annotations.SerializedName

class UserData {

    @SerializedName("name")
    var name : String ? = null

    @SerializedName("userId")
    var userId : String ? = null

    @SerializedName("password")
    var password : String ? = null

    @SerializedName("phoneNumber")
    var phoneNumber : String ? = null

    constructor(name: String?, userId: String?, password: String?, phoneNumber: String?) {
        this.name = name
        this.userId = userId
        this.password = password
        this.phoneNumber = phoneNumber
    }

    constructor(userId: String?, password: String?) {
        this.userId = userId
        this.password = password
    }

}
