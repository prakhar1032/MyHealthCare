package com.care.myhealthcare.api

data class NewsX(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)