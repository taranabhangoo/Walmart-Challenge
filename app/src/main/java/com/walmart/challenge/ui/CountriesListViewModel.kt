package com.walmart.challenge.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmart.challenge.data.repository.Country
import com.walmart.challenge.domain.usecases.GetCountriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CountriesListViewModel(
    val getCountriesUseCase: GetCountriesUseCase
): ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus: LiveData<ApiStatus>
        get() = _apiStatus

    private fun getCountriesList() {
        _apiStatus.postValue(ApiStatus.LOADING)
        viewModelScope.launch (Dispatchers.Main) {
            try {
                val response = withContext(Dispatchers.IO) {
                    getCountriesUseCase()
                }
                _countries.postValue(response)
                _apiStatus.postValue(ApiStatus.DONE)
            } catch(exception: Exception) {
                _apiStatus.postValue(ApiStatus.ERROR)
                // In real app, we would send this data to our analytics for analysis
                Log.d("CountriesListViewModel", "$exception handled !")
            }

        }
    }

    fun onViewCreated() {
        getCountriesList()
    }
}

enum class ApiStatus {
    LOADING,
    ERROR,
    DONE
}