package com.walmart.challenge.common

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseBindingActivity<BINDING: ViewBinding>: AppCompatActivity() {

    protected val binding: BINDING by lazy {
        inflateBinding(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    protected abstract fun inflateBinding(inflater: LayoutInflater): BINDING
}