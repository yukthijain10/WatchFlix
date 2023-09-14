package com.example.watchflix.network.Data

data class Popular(
    val page: Int,
    val results: List<popularResult>,
    val total_pages: Int,
    val total_results: Int
)