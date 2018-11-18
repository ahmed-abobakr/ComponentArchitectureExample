package com.andlausia.componentarchitectureexample.main.di;

import com.andlausia.componentarchitectureexample.base.data.di.BaseCloudModule;
import com.andlausia.componentarchitectureexample.base.di.ActivityScoped;
import com.andlausia.componentarchitectureexample.base.di.ContextModule;
import com.andlausia.componentarchitectureexample.main.data.service.GitHubCloud;
import com.andlausia.componentarchitectureexample.main.view.adapter.ProjectAdapter;
import com.andlausia.componentarchitectureexample.main.viewmodel.MainViewModel;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module(includes = BaseCloudModule.class)
public class MainModule {

    @Provides
    GitHubCloud gitHubCloud(Retrofit retrofit){
        return new GitHubCloud(retrofit);
    }

    @Provides
    MainViewModel mainViewModel(GitHubCloud cloud){
        return new MainViewModel(cloud);
    }

    @Provides
    ProjectAdapter projectAdapter(){
        return new ProjectAdapter();
    }
}
