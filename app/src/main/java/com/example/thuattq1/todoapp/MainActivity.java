package com.example.thuattq1.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 20;
    private final int DEFAULT_POS = -1;

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        // items = new ArrayList();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        /*items.add("First item");
        items.add("Second item");*/

        setupListViewListener();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String newContent = data.getExtras().getString("content");
            int pos = data.getExtras().getInt("pos", DEFAULT_POS);

            if (pos != DEFAULT_POS && pos >= 0) {
                items.set(pos, newContent);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
            }
        }
    }

    public void onAddItem(View v) {
        EditText etItem = (EditText) findViewById(R.id.etNewItem);
        String itemContent = etItem.getText().toString();
        if(itemContent != null && !"".equals(itemContent)) {
            items.add(itemContent);
            etItem.setText("");
        }
        writeItems();
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView adapter, View item, int pos, long id) {
                items.remove(pos);
                itemsAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView adapter, View item, int pos, long id){
                Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                i.putExtra("pos", pos);
                i.putExtra("content", items.get(pos));
                // startActivity(i);
                startActivityForResult(i, REQUEST_CODE);
            }
                }
        );
    }

    private void readItems() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try{
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException ex) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File fileDir = getFilesDir();
        File todoFile = new File(fileDir, "todo.txt");
        try{
            FileUtils.writeLines(todoFile, items);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
