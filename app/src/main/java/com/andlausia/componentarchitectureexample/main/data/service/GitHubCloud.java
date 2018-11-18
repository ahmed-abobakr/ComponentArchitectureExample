package com.andlausia.componentarchitectureexample.main.data.service;

import android.arch.lifecycle.MutableLiveData;

import com.andlausia.componentarchitectureexample.base.data.BaseCloud;
import com.andlausia.componentarchitectureexample.main.data.models.Project;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GitHubCloud extends BaseCloud {


    public GitHubCloud(Retrofit retrofit) {
        super(retrofit);
    }

    public MutableLiveData<List<Project>> getProjectList(String user){
        MutableLiveData<List<Project>> projects = new MutableLiveData<>();
        execute(GitHubService.class).getProjectList(user).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                if (response.body() != null)
                    projects.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                projects.setValue(null);
            }
        });

        return projects;
    }

    /*public MutableLiveData<Project> getProjectDetails(String user, String projectName){
        return execute(GitHubService.class).getProjectDetails(user, projectName);
    }*/
}
