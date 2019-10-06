package com.example.inyeon.server

import com.example.inyeon.UserData
import retrofit2.Call
import retrofit2.http.*

interface APIMethod {

    @POST("/api/user/")
    fun postRequest(@Body userData: UserData): Call<UserData>

    @GET("/api/login/{userId}")
    fun loginRequest(
        @Path(value = "userId", encoded = true) userId: String,
        @Query("userId") id: String,
        @Query("password") password: String
    ): Call<String>
}