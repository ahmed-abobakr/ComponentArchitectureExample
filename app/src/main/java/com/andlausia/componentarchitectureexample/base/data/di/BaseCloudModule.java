package com.andlausia.componentarchitectureexample.base.data.di;

import com.andlausia.componentarchitectureexample.base.data.BaseCloud;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class BaseCloudModule {

    private final String BASE_URL = "https://api.github.com/";

    @Provides
    BaseCloud baseCloud(Retrofit retrofit){
        return new BaseCloud(retrofit);
    }

    @Provides
    Retrofit providesRetrofit(OkHttpClient client,
                              GsonConverterFactory factory){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    Gson gson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
