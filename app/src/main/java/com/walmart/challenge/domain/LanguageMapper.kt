package com.walmart.challenge.domain

import com.walmart.challenge.data.repository.Language
import com.walmart.challenge.data.source.remote.LanguageEntity

class LanguageMapper: Mapper<LanguageEntity?, Language> {

    override fun map(input: LanguageEntity?): Language {
        return Language(
            code = input?.code.orEmpty(),
            name = input?.name.orEmpty()
        )
    }
}