package com.example.watchflix.network.Data

data class Upcoming(
    val dates: Dates,
    val page: Int,
    val results: List<upComingResult>,
    val total_pages: Int,
    val total_results: Int
)