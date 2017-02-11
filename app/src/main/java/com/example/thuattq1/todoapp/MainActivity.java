package com.example.thuattq1.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.thuattq1.business.TaskMgr;
import com.example.thuattq1.entity.TaskEntity;
import com.example.thuattq1.exception.BusinessException;
import com.example.thuattq1.todoapp.view.task.TaskListAdapter;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuattq1 on 2/10/2017.
 */

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 20;
    private final int DEFAULT_POS = -1;

    private List<TaskEntity> items;
    private TaskListAdapter itemsAdapter;
    private ListView lvItems;

    private TaskMgr taskMgr = new TaskMgr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);

        readItems();
        itemsAdapter = new TaskListAdapter(this, items);
        lvItems.setAdapter(itemsAdapter);

        setupListViewListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            int pos = data.getExtras().getInt("pos", DEFAULT_POS);
            TaskEntity taskNew = (TaskEntity) Parcels.unwrap(data.getParcelableExtra("task"));

            if (pos != DEFAULT_POS && pos >= 0
                    && taskNew != null) {
                TaskEntity taskOld = items.get(pos);
                taskOld.taskName = taskNew.taskName;
                writeItems(taskOld);

                itemsAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onAddItem(View v) {
        EditText etItem = (EditText) findViewById(R.id.etNewItem);
        String itemContent = etItem.getText().toString();
        if(itemContent != null && !"".equals(itemContent)) {
            try{
                int newId = this.taskMgr.getMaxId();
                TaskEntity task = new TaskEntity();
                task.id = newId;
                task.taskName = itemContent;
                task.save();

                items.add(task);
                itemsAdapter.notifyDataSetChanged();
            } catch (BusinessException e) {
                Log.e("insert task err", e.getMessage(), e);
            }

            etItem.setText("");
        }
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView adapter, View item, int pos, long id) {
                        TaskEntity task = items.get(pos);
                        if(task != null) {
                            task.delete();
                        }

                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }
                });

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView adapter, View item, int pos, long id){
                        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                        if(pos >= 0 && items.get(pos) != null) {
                            i.putExtra("pos", pos);
                            i.putExtra("task", Parcels.wrap(items.get(pos)));

                            // startActivity(i);
                            startActivityForResult(i, REQUEST_CODE);
                        }
                    }
                }
        );
    }

    private void readItems() {
        try {
            items = this.taskMgr.getAllTask();
        } catch (BusinessException ex) {
            Log.e("get all task error", ex.getMessage(), ex);
        }

        if(items == null) {
            items = new ArrayList<TaskEntity>();
        }
    }

    private void writeItems(TaskEntity task) {
        if(task == null) {
            throw new IllegalArgumentException("entity is null");
        }

        task.save();
    }
}
