package com.walmart.challenge.ui.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.walmart.challenge.ui.CountriesListViewModel
import com.walmart.challenge.domain.usecases.GetCountriesUseCase

class ViewModelFactory(private val useCase: GetCountriesUseCase) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(CountriesListViewModel::class.java) -> CountriesListViewModel(useCase)
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            }
        } as T
    }
}