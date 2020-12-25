package com.sammidev.payload

data class PayloadResponse<T>(
        val code: Int,
        val status: String,
        val data: T,
)