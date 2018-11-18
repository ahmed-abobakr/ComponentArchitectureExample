package com.andlausia.componentarchitectureexample.base.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public  class ContextModule {

    Application context;

    public ContextModule(Application context){
        this.context = context;
    }

    @Named("application_context")
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }


}
