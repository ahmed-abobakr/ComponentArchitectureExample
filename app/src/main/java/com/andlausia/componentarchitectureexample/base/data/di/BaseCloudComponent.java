package com.andlausia.componentarchitectureexample.base.data.di;



import com.andlausia.componentarchitectureexample.base.data.BaseCloud;

import dagger.Component;


@Component(modules = BaseCloudModule.class)
public interface BaseCloudComponent {
    BaseCloud getBaseCloud();
}
