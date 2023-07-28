package com.example.watchflix.network.Data

data class Toprated(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)