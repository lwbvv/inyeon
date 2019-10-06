package com.example.inyeon.login

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.example.inyeon.base.BasePresenter




interface LoginContract {

    interface View{

        fun loginButtonClick()
        fun failToast()
        fun loginResult(message: String)

    }

    interface Presenter : BasePresenter<View>{

        fun sendLoginData(userId : String, password : String)
    }

    interface Model{
        fun getLoginResult(userId : String, password : String, onFinishedListener: OnFinishedListener)

       interface OnFinishedListener {
            fun onFinished(result: String)

            fun onFailure()
        }
    }
}