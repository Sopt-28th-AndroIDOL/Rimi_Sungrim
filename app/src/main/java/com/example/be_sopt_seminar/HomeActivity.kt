package com.example.be_sopt_seminar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.be_sopt_seminar.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Home Lifecycle", "onCreate()")
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Home Lifecycle", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Home Lifecycle", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Home Lifecycle", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Home Lifecycle", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Home Lifecycle", "onDestroy()")
    }
}