package com.walmart.challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.walmart.challenge.R
import com.walmart.challenge.common.BaseBindingFragment
import com.walmart.challenge.data.repository.DefaultCountriesRepository
import com.walmart.challenge.data.source.remote.RetrofitRemoteDataSource
import com.walmart.challenge.databinding.FragmentCountriesListBinding
import com.walmart.challenge.domain.CountryMapper
import com.walmart.challenge.domain.CurrencyMapper
import com.walmart.challenge.domain.LanguageMapper
import com.walmart.challenge.domain.usecases.GetCountriesUseCaseImpl
import com.walmart.challenge.ui.factory.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [CountriesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountriesListFragment : BaseBindingFragment<FragmentCountriesListBinding>() {

    private lateinit var viewModel: CountriesListViewModel

    private val countriesListAdapter by lazy { CountriesListAdapter() }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCountriesListBinding {
        return FragmentCountriesListBinding.inflate(
            inflater,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        injectDependencies()

        // set up recycler view
        requireBinding().recyclerView.apply {
            adapter = countriesListAdapter
            addItemDecoration(VerticalItemDecoration(
                requireContext()
            ))
        }

        // Now register observers to view model's data
        registerObservers()

        // tell view model that view is created
        viewModel.onViewCreated()
    }

    private fun injectDependencies() {
        val repository = DefaultCountriesRepository(
            RetrofitRemoteDataSource()
        )

        val getCountriesUseCase = GetCountriesUseCaseImpl(
            repository,
            CountryMapper(
                LanguageMapper(),
                CurrencyMapper()
            )
        )
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(getCountriesUseCase)
        )[CountriesListViewModel::class.java]
    }

    private fun registerObservers() {
        viewModel.countries.observe(viewLifecycleOwner) {
            // pass the data to the adapters
            countriesListAdapter.submitList(it)
        }
        viewModel.apiStatus.observe(viewLifecycleOwner) {
            onApiStatusChanged(it)
        }
    }

    private fun onApiStatusChanged(apiStatus: ApiStatus) {
        when (apiStatus) {
            ApiStatus.LOADING -> {
                with(requireBinding()) {
                    statusImage.visibility = View.VISIBLE
                    statusImage.setImageResource(R.drawable.loading_animation)
                    recyclerView.visibility = View.GONE
                }
            }
            ApiStatus.ERROR -> {
                with(requireBinding()) {
                    statusImage.visibility = View.VISIBLE
                    statusImage.setImageResource(R.drawable.ic_broken_image)
                }
            }
            ApiStatus.DONE -> {
                with(requireBinding()) {
                    statusImage.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
            }
        }
    }

    companion object {
        const val TAG: String = "CountriesListFragment"
    }
}