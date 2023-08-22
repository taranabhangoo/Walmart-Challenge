package com.walmart.challenge.domain.usecases

import com.walmart.challenge.data.repository.Country

interface GetCountriesUseCase {
    suspend operator fun invoke(): List<Country>
}