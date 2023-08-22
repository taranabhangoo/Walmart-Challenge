package com.walmart.challenge.data.repository

import com.walmart.challenge.data.source.remote.CountryEntity

interface CountriesRepository {

    suspend fun getCountries(): List<CountryEntity>
}