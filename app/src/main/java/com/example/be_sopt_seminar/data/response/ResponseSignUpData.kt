package com.example.be_sopt_seminar.data.response

data class ResponseSignUpData(
    val success: Boolean,
    val message: String,
    val data: Data?
) {
    data class Data(
        val nickname: String
    )
}