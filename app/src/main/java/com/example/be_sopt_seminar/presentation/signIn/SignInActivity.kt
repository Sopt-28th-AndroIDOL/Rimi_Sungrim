package com.example.be_sopt_seminar.presentation.signIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.be_sopt_seminar.api.SoptServiceImpl
import com.example.be_sopt_seminar.data.request.RequestLoginData
import com.example.be_sopt_seminar.data.response.ResponseLoginData
import com.example.be_sopt_seminar.databinding.ActivitySignInBinding
import com.example.be_sopt_seminar.presentation.signUp.SignUpActivity
import com.example.be_sopt_seminar.presentation.home.HomeActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginButtonClickEvent()
        signUpButtonClickEvent()
    }

    private fun loginButtonClickEvent() {
        binding.signInBtnLogin.setOnClickListener {
            val requestLoginData = RequestLoginData(
                id = binding.signInEdtId.text.toString(),
                password = binding.signInEdtPw.text.toString()
            )

            val call: Call<ResponseLoginData> = SoptServiceImpl.soptService
                .postLogin(requestLoginData)

            call.enqueue(object : Callback<ResponseLoginData> {
                override fun onResponse(
                    call: Call<ResponseLoginData>,
                    response: Response<ResponseLoginData>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()?.data
                        Toast.makeText(this@SignInActivity, "${data?.user_nickname}님, 로그인 성공", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@SignInActivity, "아이디 또는 비밀번호를 확인해 주세요.", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                    Log.d("NetworkTest", "error:$t")
                }
            })
        }
    }

    private fun signUpButtonClickEvent() {
        binding.signInTvSignup.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }
}