package com.desmart.gitlabapkinstaller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desmart.gitlabapkinstaller.model.project.ProjectEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nataliajastrzebska on 16/03/16.
 */
public class ProjectsRecyclerViewAdapter extends RecyclerView.Adapter<ProjectsRecyclerViewAdapter.ViewHolder> {

    private List<ProjectEntity> projectEntities;
    private Context context;

    public ProjectsRecyclerViewAdapter(Context context, List<ProjectEntity> projectEntities) {
        this.context = context;
        this.projectEntities = projectEntities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_project, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProjectEntity projectEntity = this.projectEntities.get(position);
        holder.nameTextView.setText(projectEntity.getNameWithNamespace());
        holder.descriptionTextView.setText(projectEntity.getDescription());
    }

    @Override
    public int getItemCount() {
        return projectEntities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.projectNameTextView)
        TextView nameTextView;
        @Bind(R.id.projectDescriptionTextView)
        TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}


