package com.example.inyeon.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {

    val BASE_URL = "http://ec2-15-164-221-8.ap-northeast-2.compute.amazonaws.com:8000"
    var retrofit : Retrofit ? = null
//    private val networkingFail: Int = 4444 //연결 실패
//    private val notFindId: Int = 5555     //아이디를 찾을 수 없음
//    private val missPassword: Int = 6666 //패스워드가 일치하지 않음
//    private val loginSuccess: Int = 7777 //회원가입 성공

    constructor() {
            this.retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}