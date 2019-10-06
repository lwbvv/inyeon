package com.example.inyeon.login

import android.content.Context
import com.example.inyeon.server.RetrofitConfig
import com.example.inyeon.server.APIMethod

class LoginPresenter : LoginContract.Presenter, LoginContract.Model.OnFinishedListener{
//    var server : APIMethod ? = null
//    private var loginView : LoginContract.View ? = null
//    private lateinit var retrofitConfig: RetrofitConfig
//    override fun takeView(view: LoginContract.View) {
//        loginView = view
//    }
//
//    fun createModel(userId: String, password: String){
//        userModel = UserData(userId, password)
//    }
//
//    override fun loginCheck(userId : String, password : String, context: Context) : Int {
//        var memberArrays: Array<String> = arrayOf(userId, password) //회원 아이디랑 비밀번호를 담아준다
//
//        retrofitConfig = RetrofitConfig() //레트로핏 객체를 생성
//
//        var result = retrofitConfig.retrofit?.create(APIMethod::class.java)
//        server = result
//    }
//
//
//    override fun dropView() {
//        loginView = null
//    }

    var loginView : LoginContract.View ? = null
    private lateinit var loginModel: LoginModel

    constructor(loginView: LoginContract.View) {
        this.loginView = loginView
        loginModel = LoginModel()
    }


    override fun sendLoginData(userId : String, password : String) {
        loginModel.getLoginResult(userId,password, this)
    }

    override fun dropView() {
        loginView = null
    }

    override fun onFinished(result: String) {
        loginView?.loginResult(result)
    }

    override fun onFailure() {
      loginView?.failToast()
    }


}