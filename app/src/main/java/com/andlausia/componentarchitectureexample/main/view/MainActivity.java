package com.andlausia.componentarchitectureexample.main.view;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.andlausia.componentarchitectureexample.R;
import com.andlausia.componentarchitectureexample.base.di.ContextModule;
import com.andlausia.componentarchitectureexample.base.view.BaseActivity;
import com.andlausia.componentarchitectureexample.databinding.ActivityMainBinding;
import com.andlausia.componentarchitectureexample.main.data.models.Project;
import com.andlausia.componentarchitectureexample.main.di.DaggerMainComponent;
import com.andlausia.componentarchitectureexample.main.di.MainComponent;
import com.andlausia.componentarchitectureexample.main.view.adapter.ProjectAdapter;
import com.andlausia.componentarchitectureexample.main.viewmodel.MainViewModel;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseActivity<MainViewModel> {


    @Inject
    MainViewModel viewModel;
    @Inject
    ProjectAdapter adapter;

    @Override
    public MainViewModel initViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainComponent component = DaggerMainComponent.builder()
                .contextModule(new ContextModule(getApplication()))
                .build();
        component.injectMainActivity(this);
        super.onCreate(savedInstanceState);


        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(viewModel);
        activityMainBinding.executePendingBindings();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        activityMainBinding.projectsRecycler.setLayoutManager(manager);
        activityMainBinding.projectsRecycler.setAdapter(adapter);

        viewModel.setUser("Google");

        viewModel.getProjects().observe(this, projects -> {
            if(projects != null){
                adapter.setProjectList(projects);
                for (Project project : projects){
                    Log.d("TEST", "Name: " + project.full_name);
                }
            }
        });
    }
}
