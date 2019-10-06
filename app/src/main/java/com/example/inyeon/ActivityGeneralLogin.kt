package com.example.inyeon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.inyeon.base.BaseActivity
import com.example.inyeon.login.LoginContract
import com.example.inyeon.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_general_login.*

class ActivityGeneralLogin : BaseActivity(), LoginContract.View {
    private val networkingFail: Int = 4444 //연결 실패
    private val notFindId: Int = 5555     //아이디를 찾을 수 없음
    private val missPassword: Int = 6666 //패스워드가 일치하지 않음
    private val loginSuccess: Int = 7777 //회원가입 성공
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_login)
        initPresenter()
        loginButtonClick()
    }

    override fun initPresenter() {
        loginPresenter = LoginPresenter(this@ActivityGeneralLogin)
    }


    override fun loginButtonClick() {
        loginSend.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        loginSend.setOnClickListener {
            loginPresenter.sendLoginData(loginId.text.toString(), loginPassword.text.toString()) //프리젠터에 유저가 입력한 정보를 전달
        }
    }

    //로그인 실패시 토스트 메시지 띄우기
    override fun failToast() {

        Toast.makeText(this@ActivityGeneralLogin, "네트워크 연결이 불안정합니다", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this@ActivityGeneralLogin, ActivityMain::class.java))//로그인 성공시 메인액티비티로 이동
    }


    override fun loginResult(message: String) {
        when (message) {
            "1" -> Toast.makeText(this@ActivityGeneralLogin, "존재하지 않는 아이디 입니다", Toast.LENGTH_SHORT).show()
            "2" -> Toast.makeText(this@ActivityGeneralLogin, "패스워드가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            else -> startActivity(Intent(this@ActivityGeneralLogin, ActivityMain::class.java))//로그인 성공시 메인액티비티로 이동
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.dropView()
    }
}