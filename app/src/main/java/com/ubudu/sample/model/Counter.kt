package com.ubudu.sample.model

import java.util.Timer
import java.util.TimerTask

/**
 * Created by Aga on 02.02.2018.
 */

class Counter(counterMaxValue: Int) {

    var listener: CounterListener? = null

    private var counter = 0
    private var counterMaxValue = 0
    private var counterTimer = Timer()
    private var counterTimerTask: TimerTask? = null

    init {
        this.counterMaxValue = counterMaxValue
    }

    /**
     *
     */
    fun start() {
        // set initial value
        setValue(0)
        // new timer task
        counterTimerTask = object : TimerTask() {
            override fun run() {
                if (counter < counterMaxValue)
                    setValue(++counter)
                else
                    setValue(0)
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
        setValue(0)
    }

    /**
     *
     */
    private fun setValue(newValue: Int) {
        counter = newValue
        listener?.onValueChanged(counter)
    }

    interface CounterListener {
        fun onValueChanged(value: Int)
    }
}
