package com.walmart.challenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.walmart.challenge.data.repository.Country
import com.walmart.challenge.databinding.ItemCountryBinding

class CountriesListAdapter: ListAdapter<Country, CountriesListAdapter.CountryViewHolder>(DiffCallback) {

    companion object DiffCallback: DiffUtil.ItemCallback<Country>() {
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }

    }

    inner class CountryViewHolder(private val binding: ItemCountryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }
}