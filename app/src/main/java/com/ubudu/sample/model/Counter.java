package com.ubudu.sample.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Aga on 02.02.2018.
 */

public class Counter {

    MutableLiveData <Integer> counter =  new MutableLiveData<>();

    public MutableLiveData<Integer> getCounter(){
        return counter;
    }

    public void startCounter(){

        //aga: zawsze z main thread'a
        counter.setValue(999);

        Timer start = new Timer();
        start.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i=0; i<2000; i++){
                    //aga: zawsze z worker thread'a
                    counter.postValue(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 2000);

    }


}
