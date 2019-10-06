package com.example.inyeon.login

import android.util.Log
import com.example.inyeon.server.APIMethod
import com.example.inyeon.server.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginModel : LoginContract.Model{
    var apiMethod: APIMethod ? = null
    val ConnectFail = "0"


    override fun getLoginResult(userId : String, password : String, onFinishedListener: LoginContract.Model.OnFinishedListener) {
       var service = RetrofitConfig()
        apiMethod = service.retrofit?.create(APIMethod::class.java)


        apiMethod?.loginRequest(userId, userId, password)?.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.i("fail", t.toString())
                onFinishedListener.onFailure()
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                when(response?.body().toString()) {
                }
                Log.i("success", response?.body().toString())
                onFinishedListener.onFinished(response?.body().toString())
            }
        })




        }
}