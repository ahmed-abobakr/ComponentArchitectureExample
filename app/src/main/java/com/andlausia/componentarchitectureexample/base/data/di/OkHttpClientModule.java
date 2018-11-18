package com.andlausia.componentarchitectureexample.base.data.di;

import android.content.Context;
import android.util.Log;

import com.andlausia.componentarchitectureexample.base.di.ContextModule;

import java.io.File;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

@Module(includes = {ContextModule.class})
public class OkHttpClientModule {


    @Provides
    OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor){
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            /*requestBuilder.addHeader(APP_AUTH_HEADER, APP_AUTH_HEADER_VALUE);
            requestBuilder.addHeader("LANG", getDefaultLanguage.getLocaleLanguage());*/
            return chain.proceed(requestBuilder.build());
        }).addInterceptor(httpLoggingInterceptor)
                .cache(cache);
        return builder.build();
    }

    @Provides
    Cache cache(File cacheFile){
        return new Cache(cacheFile, 10 * 100 * 1000);//10MB
    }

    @Provides
    File file(@Named("application_context")Context context){
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(OkHttpClient.class.getSimpleName(), message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
