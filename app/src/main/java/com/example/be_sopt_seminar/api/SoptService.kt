package com.example.be_sopt_seminar.api

import com.example.be_sopt_seminar.data.request.RequestLoginData
import com.example.be_sopt_seminar.data.request.RequestSignUpData
import com.example.be_sopt_seminar.data.response.ResponseLoginData
import com.example.be_sopt_seminar.data.response.ResponseSignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ) : Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ) : Call<ResponseSignUpData>
}