package com.andlausia.componentarchitectureexample.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public abstract class BaseActivity<T> extends AppCompatActivity {

    T viewModel;

    public abstract T initViewModel();

    public T getViewModel(){
        if(viewModel == null)
              viewModel = initViewModel();
        return viewModel;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
