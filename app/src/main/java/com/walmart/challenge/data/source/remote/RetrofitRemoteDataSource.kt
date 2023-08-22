package com.walmart.challenge.data.source.remote

class RetrofitRemoteDataSource: RemoteDataSource {

    override suspend fun getCountriesList(): List<CountryEntity> {
        return CountryApi.retrofitService.getCountries()
    }
}