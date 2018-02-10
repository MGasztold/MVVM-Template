package com.ubudu.sample.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

import com.ubudu.sample.model.Counter

/**
 * Created by Aga on 02.02.2018.
 *
 */

class CounterViewModel(counterMaxValue: Int) : ViewModel() {

    val counterLiveData: LiveData<Int>

    private val counter: Counter = Counter(counterMaxValue)

    init {
        counterLiveData = counter.liveData
    }

    /**
     *
     */
    fun start() {
        counter.start()
    }

    /**
     *
     */
    fun reset() {
        counter.stop()
        counter.start()
    }
}
