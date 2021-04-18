package com.example.be_sopt_seminar.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.be_sopt_seminar.databinding.ActivitySignUpBinding

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
                val intent = Intent()
                intent.putExtra("userName", userName)
                intent.putExtra("userId", userId)
                intent.putExtra("userPw", userPw)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}