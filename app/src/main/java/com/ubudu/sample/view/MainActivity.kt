package com.ubudu.sample.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.ubudu.sample.R
import com.ubudu.sample.viewmodel.CounterViewModel
import com.ubudu.sample.viewmodel.CounterViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Counter View Model
    private var counterViewModel: CounterViewModel? = null

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init counter view model
        counterViewModel = ViewModelProviders.of(this, CounterViewModelFactory(10))
                .get(CounterViewModel::class.java)

        // start observing liveData view model
        observeViewModel(counterViewModel!!)

        // start counter
        counterViewModel?.start()

        // configure button
        configureButtons()
    }

    /**
     *
     */
    private fun configureButtons() {
        sample_button.setOnClickListener {
            // stop counter
            counterViewModel?.reset()
        }
    }

    /**
     *
     */
    private fun observeViewModel(counterViewModel: CounterViewModel) {
        counterViewModel.counterLiveData.observe(this, Observer { integer ->
            // update the textview with the latest value of the liveData
            textMain.text = integer.toString()
        })
    }
}
