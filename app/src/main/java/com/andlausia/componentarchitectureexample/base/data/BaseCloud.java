package com.andlausia.componentarchitectureexample.base.data;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class BaseCloud {

    Retrofit retrofit;

    @Inject
    public BaseCloud(Retrofit retrofit){
        this.retrofit = retrofit;
    }

    protected <T> T execute(Class<T> cls){
        return retrofit.create(cls);
    }

}
