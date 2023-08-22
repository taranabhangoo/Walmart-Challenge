package com.walmart.challenge

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.commit
import com.walmart.challenge.common.BaseBindingActivity
import com.walmart.challenge.databinding.ActivityMainBinding
import com.walmart.challenge.ui.CountriesListFragment

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun inflateBinding(inflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set action bar
        setSupportActionBar(binding.toolbar)

        // Set the fragment
        val fragment = CountriesListFragment()
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(
                binding.fragmentContainer.id,
                fragment,
                CountriesListFragment.TAG
            )
        }
    }
}