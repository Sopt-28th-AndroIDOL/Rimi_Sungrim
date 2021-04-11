package com.example.be_sopt_seminar

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.be_sopt_seminar.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SignUp Lifecycle", "onCreate()")
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

    override fun onStart() {
        super.onStart()
        Log.d("SignUp Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SignUp Lifecycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SignUp Lifecycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SignUp Lifecycle", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SignUp Lifecycle", "onDestroy()")
    }
}