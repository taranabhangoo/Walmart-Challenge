package com.walmart.challenge.domain

import com.walmart.challenge.data.repository.Country
import com.walmart.challenge.data.source.remote.CountryEntity

class CountryMapper(
    private val languageMapper: LanguageMapper,
    private val currencyMapper: CurrencyMapper
    ): Mapper<CountryEntity, Country> {

    override fun map(input: CountryEntity): Country {
        return with(input) {
            Country(
                code = code,
                name = name,
                region = region.orEmpty(),
                capital = capital.orEmpty(),
                language = languageMapper.map(language),
                currency = currencyMapper.map(currency),
                flag = flag.orEmpty()
            )
        }
    }
}

