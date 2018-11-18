package com.andlausia.componentarchitectureexample.main.di;

import com.andlausia.componentarchitectureexample.base.data.di.BaseCloudModule;
import com.andlausia.componentarchitectureexample.base.di.ActivityScoped;
import com.andlausia.componentarchitectureexample.main.view.MainActivity;

import dagger.Component;

@ActivityScoped
@Component(modules = {BaseCloudModule.class, MainModule.class})
public interface MainComponent {

    void injectMainActivity(MainActivity mainActivity);
}
