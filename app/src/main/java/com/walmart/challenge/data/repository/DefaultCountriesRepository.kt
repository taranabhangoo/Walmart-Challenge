package com.walmart.challenge.data.repository

import com.walmart.challenge.data.source.remote.CountryEntity
import com.walmart.challenge.data.source.remote.RemoteDataSource

class DefaultCountriesRepository(
    private val remoteDataSource: RemoteDataSource
    // If there is a database, then we can pass local data source here as well
): CountriesRepository {

    override suspend fun getCountries(): List<CountryEntity> {
        return remoteDataSource.getCountriesList()
    }
}