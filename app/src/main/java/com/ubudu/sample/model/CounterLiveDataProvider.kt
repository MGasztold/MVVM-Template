package com.ubudu.sample.model

import android.arch.lifecycle.MutableLiveData

/**
 * Created by mgasztold on 10/02/2018.
 */
class CounterLiveDataProvider(counterMaxValue: Int) {

    val liveData = MutableLiveData<Int>()
    private val counter: Counter = Counter(counterMaxValue)

    init {
        counter.listener = object : Counter.CounterListener {
            override fun onValueChanged(value: Int) {
                liveData.postValue(value)
            }
        }
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
    fun stop() {
        counter.stop()
    }
}