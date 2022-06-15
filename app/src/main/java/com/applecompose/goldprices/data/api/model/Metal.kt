package com.applecompose.goldprices.data.api.model

data class Metal(
    val base: String,
    val date: String,
    val rates: Rates,
    val success: Boolean,
    val timestamp: Int,
    val unit: String
)