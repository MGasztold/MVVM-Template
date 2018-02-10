package com.ubudu.sample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.ubudu.sample.R;
import com.ubudu.sample.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;

    @BindView(R.id.textMain)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //aga: mozemy stworzyc wlasna fabryke, wtedy ja przekazujemy w of(this, factory). ponoc tak jest szybciej
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        observeViewModel(mainViewModel);
    }

    private void observeViewModel(MainViewModel mainViewModel){
        mainViewModel.getCounterText().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                Log.d("MainActivity", "Counter: " + integer + " " + (textView==null));
                textView.setText(String.valueOf(integer));
            }
        });
    }
}
