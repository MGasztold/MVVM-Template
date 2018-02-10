package com.ubudu.sample.model

import android.arch.lifecycle.MutableLiveData

import java.util.Timer
import java.util.TimerTask

/**
 * Created by Aga on 02.02.2018.
 */

class Counter(counterMaxValue: Int) {

    val liveData = MutableLiveData<Int>()

    private var counterTimer = Timer()
    private var counterMaxValue = 0
    private var counterTimerTask: TimerTask? = null

    init {
        this.counterMaxValue = counterMaxValue
        liveData.value = 0
    }

    /**
     *
     */
    fun start() {
        // new timer task
        counterTimerTask = object : TimerTask() {
            override fun run() {
                liveData.postValue(liveData.value!! + 1)
            }
        }
        // new Timer
        counterTimer = Timer()
        // schedule timer task
        counterTimer.scheduleAtFixedRate(counterTimerTask, 1000, 1000)
    }

    /**
     *
     */
    fun stop() {
        counterTimerTask?.cancel()
        liveData.value = 0
    }
}
