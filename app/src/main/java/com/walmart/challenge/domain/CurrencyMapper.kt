package com.walmart.challenge.domain

import com.walmart.challenge.data.repository.Currency
import com.walmart.challenge.data.source.remote.CurrencyEntity

class CurrencyMapper: Mapper<CurrencyEntity?, Currency> {
    override fun map(input: CurrencyEntity?): Currency {
        return Currency(
            code = input?.code.orEmpty(),
            name = input?.name.orEmpty(),
            symbol = input?.symbol.orEmpty()
        )
    }
}