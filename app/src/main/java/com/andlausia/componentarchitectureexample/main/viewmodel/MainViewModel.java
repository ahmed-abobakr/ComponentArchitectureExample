package com.andlausia.componentarchitectureexample.main.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


import com.andlausia.componentarchitectureexample.main.data.models.Project;
import com.andlausia.componentarchitectureexample.main.data.service.GitHubCloud;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    @Inject
    GitHubCloud cloud;

    private MutableLiveData<String> user;



    @Inject
    public MainViewModel(GitHubCloud cloud){
        this.cloud = cloud;
        this.user = new MutableLiveData<>();
    }

    public void setUser(String  user){
        this.user.setValue(user);
    }



    public LiveData<List<Project>> getProjects(){
        return cloud.getProjectList(user.getValue());
    }
}
