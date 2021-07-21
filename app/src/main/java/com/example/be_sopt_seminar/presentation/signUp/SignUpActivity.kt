package com.example.be_sopt_seminar.presentation.signUp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.be_sopt_seminar.api.SoptServiceImpl
import com.example.be_sopt_seminar.data.request.RequestLoginData
import com.example.be_sopt_seminar.data.request.RequestSignUpData
import com.example.be_sopt_seminar.data.response.ResponseLoginData
import com.example.be_sopt_seminar.data.response.ResponseSignUpData
import com.example.be_sopt_seminar.databinding.ActivitySignUpBinding
import com.example.be_sopt_seminar.presentation.home.HomeActivity
import com.example.be_sopt_seminar.presentation.signIn.SignInActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signUpButtonClickEvent()
    }

    private fun signUpButtonClickEvent() {
        binding.signUpBtnSignup.setOnClickListener {
            val userName = binding.signUpEdtName.text
            val userId = binding.signUpEdtId.text
            val userPw = binding.signUpEdtPw.text

            if (userName.isNullOrBlank() || userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈 칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val requestSignUpData = RequestSignUpData(
                    email = binding.signUpEdtId.text.toString(),
                    password = binding.signUpEdtPw.text.toString(),
                    sex = "0",
                    nickname = binding.signUpEdtName.text.toString(),
                    phone = "010-1010-2020",
                    birth = "1996-02-24"
                )

                val call: Call<ResponseSignUpData> = SoptServiceImpl.soptService
                    .postSignUp(requestSignUpData)

                call.enqueue(object : Callback<ResponseSignUpData> {
                    override fun onResponse(
                        call: Call<ResponseSignUpData>,
                        response: Response<ResponseSignUpData>
                    ) {
                        if (response.isSuccessful) {
                            val data = response.body()?.data
                            Toast.makeText(this@SignUpActivity, "${data?.nickname}님, 반갑습니다 >_<", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignUpActivity, "이미 존재하는 이메일입니다", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                        Log.d("NetworkTest", "error:$t")
                    }
                })
            }
        }
    }
}