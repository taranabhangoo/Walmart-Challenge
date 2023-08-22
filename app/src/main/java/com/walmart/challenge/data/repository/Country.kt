package com.walmart.challenge.data.repository

data class Country(
    val code: String,
    val name: String,
    val region: String,
    val capital: String,
    val language: Language,
    val currency: Currency,
    val flag: String
)
