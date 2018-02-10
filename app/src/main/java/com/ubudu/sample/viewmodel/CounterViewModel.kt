package com.ubudu.sample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

import com.ubudu.sample.model.CounterLiveDataProvider

/**
 * Created by Aga on 02.02.2018.
 *
 */

class CounterViewModel(counterMaxValue: Int) : ViewModel() {

    val counterLiveData: LiveData<Int>

    private val counterLiveDataProvider: CounterLiveDataProvider = CounterLiveDataProvider(counterMaxValue)

    init {
        counterLiveData = counterLiveDataProvider.liveData
    }

    /**
     *
     */
    fun start() {
        counterLiveDataProvider.start()
    }

    /**
     *
     */
    fun reset() {
        counterLiveDataProvider.stop()
        counterLiveDataProvider.start()
    }
}
