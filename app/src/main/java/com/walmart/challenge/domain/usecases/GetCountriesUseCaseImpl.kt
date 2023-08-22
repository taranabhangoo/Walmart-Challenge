package com.walmart.challenge.domain.usecases

import com.walmart.challenge.data.repository.CountriesRepository
import com.walmart.challenge.data.repository.Country
import com.walmart.challenge.domain.CountryMapper

class GetCountriesUseCaseImpl(
    val repository: CountriesRepository,
    private val countryMapper: CountryMapper
): GetCountriesUseCase {

    override suspend operator fun invoke(): List<Country> {
        return repository.getCountries().map {
            countryMapper.map(it)
        }
    }

}