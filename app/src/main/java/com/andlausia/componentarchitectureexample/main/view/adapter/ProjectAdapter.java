package com.andlausia.componentarchitectureexample.main.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andlausia.componentarchitectureexample.R;
import com.andlausia.componentarchitectureexample.databinding.ProjectItemBinding;
import com.andlausia.componentarchitectureexample.main.data.models.Project;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    List<Project> projectList;

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ProjectItemBinding binding =  DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.project_item,
                parent, false);
        return new ProjectViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.binding.setProject(projectList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if(projectList != null) {
            Log.d("TEST", "Count:" + projectList.size());
            return projectList.size();
        }else
            return  0;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
        notifyDataSetChanged();
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

          ProjectItemBinding binding;

        public ProjectViewHolder(ProjectItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
