package com.ubudu.sample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by mgasztold on 10/02/2018.
 */

class CounterViewModelFactory(private val counterMaxValue: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Int::class.java).newInstance(counterMaxValue)
    }

}
