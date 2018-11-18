package com.andlausia.componentarchitectureexample.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;



public abstract class BaseFragment<T> extends Fragment {

    T viewModel;

    abstract T initViewModel();

    public T getViewModel(){
        if(viewModel == null)
            viewModel = initViewModel();
        return viewModel;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
