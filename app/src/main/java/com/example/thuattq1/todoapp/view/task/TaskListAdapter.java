package com.example.thuattq1.todoapp.view.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thuattq1.entity.TaskEntity;
import com.example.thuattq1.todoapp.R;

import java.util.List;

/**
 * Created by thuattq1 on 2/10/2017.
 */

public class TaskListAdapter extends ArrayAdapter<TaskEntity> {
    public TaskListAdapter(Context context, List<TaskEntity> listTask) {
        super(context, 0, listTask);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TaskEntity task = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.lot_taks_list, parent, false);
        }

        // Lookup view for data population
        TextView tvTaskName = (TextView) convertView.findViewById(R.id.tvTaskName);
        TextView tvLevel = (TextView) convertView.findViewById(R.id.tvLevel);

        // Populate the data into the template view using the data object
        if(task != null) {
            tvTaskName.setText(task.taskName);
            tvLevel.setText(task.level != null ? task.level.toString() : "");
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
