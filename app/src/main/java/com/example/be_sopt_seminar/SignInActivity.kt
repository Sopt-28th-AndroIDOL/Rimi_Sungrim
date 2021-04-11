package com.example.be_sopt_seminar

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.be_sopt_seminar.databinding.ActivitySignInBinding


class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SignIn Lifecycle", "onCreate()")
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginButtonClickEvent()
        signUpButtonClickEvent()
    }

    private fun loginButtonClickEvent() {
        binding.signInBtnLogin.setOnClickListener {
            val userId = binding.signInEdtId.text
            val userPw = binding.signInEdtPw.text
            if (userId.isNullOrBlank() || userPw.isNullOrBlank()) {
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun signUpButtonClickEvent() {
        binding.signInTvSignup.setOnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            signUpActivityLauncher.launch(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SignIn Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SignIn Lifecycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SignIn Lifecycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SignIn Lifecycle", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SignIn Lifecycle", "onDestroy()")
    }
}