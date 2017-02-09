package com.example.thuattq1.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    private final int DEFAULT_POS = -1;
    EditText etEditItem;

    String content;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        etEditItem = (EditText)findViewById(R.id.etEditItem);

        content = getIntent().getStringExtra("content");
        pos = getIntent().getIntExtra("pos", DEFAULT_POS);

        if(pos != DEFAULT_POS && pos >= 0) {
            etEditItem.setText(content);
        }
    }

    public void onSubmit(View v) {
        Intent data = new Intent();
        String newContent = etEditItem.getText().toString();
        data.putExtra("content", newContent);
        data.putExtra("pos", pos); // ints work too
        setResult(RESULT_OK, data);
        this.finish();
    }
}
