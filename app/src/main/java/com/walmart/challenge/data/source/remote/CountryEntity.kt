package com.walmart.challenge.data.source.remote

import com.walmart.challenge.data.repository.Country
import com.walmart.challenge.data.repository.Currency
import com.walmart.challenge.data.repository.Language

data class CountryEntity(
    val code: String,
    val name: String,
    val region: String?,
    val capital: String?,
    val language: LanguageEntity?,
    val currency: CurrencyEntity?,
    val flag: String?
)

data class CurrencyEntity(
    val code: String?,
    val name: String?,
    val symbol: String?
)

data class LanguageEntity(
    val code: String?,
    val name: String?
)
