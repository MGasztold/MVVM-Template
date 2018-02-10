package com.ubudu.sample.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.ubudu.sample.model.Counter;

/**
 * Created by Aga on 02.02.2018.
 * aga: tu moze byc zwykly ViewModel (bez contextu)
 */

public class MainViewModel extends AndroidViewModel {

    private final LiveData<Integer> counterData;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Counter counter = new Counter();
        counterData = counter.getCounter();
        counter.startCounter();
    }

    public LiveData<Integer> getCounterText(){
        return counterData;
    }
}
