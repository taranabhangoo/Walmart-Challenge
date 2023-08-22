package com.walmart.challenge.domain

interface Mapper<I, O> {
    fun map(input: I): O
}