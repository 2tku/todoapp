package com.example.thuattq1.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.thuattq1.entity.TaskEntity;

import org.parceler.Parcels;

public class EditItemActivity extends AppCompatActivity {
    private final int DEFAULT_POS = -1;
    EditText etEditItem;

    TaskEntity task;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etEditItem = (EditText)findViewById(R.id.etEditItem);

        pos = getIntent().getIntExtra("pos", DEFAULT_POS);
        task = (TaskEntity) Parcels.unwrap(getIntent().getParcelableExtra("task"));

        if(pos != DEFAULT_POS && pos >= 0 && task != null) {
            etEditItem.setText(task.taskName);
        }
    }

    public void onSubmit(View v) {
        Intent data = new Intent();

        if(task != null) {
            this.task.taskName = etEditItem.getText().toString();

            data.putExtra("pos", pos);
            data.putExtra("task", Parcels.wrap(this.task));
        }

        setResult(RESULT_OK, data);
        this.finish();
    }
}
