package com.walmart.challenge.data.source.remote

interface RemoteDataSource {
    suspend fun getCountriesList(): List<CountryEntity>
}