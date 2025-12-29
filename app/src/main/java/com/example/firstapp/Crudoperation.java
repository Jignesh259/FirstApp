package com.example.firstapp;

import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Crudoperation extends AppCompatActivity {

    EditText etItem;
    Button btnAdd, btnUpdate, btnDelete;
    ListView listView;

    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;

    int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crudoperation);

        etItem = findViewById(R.id.etItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        listView = findViewById(R.id.listView);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        // CREATE
        btnAdd.setOnClickListener(v -> {
            String item = etItem.getText().toString().trim();
            if (!item.isEmpty()) {
                itemList.add(item);
                adapter.notifyDataSetChanged();
                etItem.setText("");
            } else {
                Toast.makeText(this, "Enter item", Toast.LENGTH_SHORT).show();
            }
        });

        // READ (Select item)
        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            etItem.setText(itemList.get(position));
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                itemList.set(selectedPosition, etItem.getText().toString());
                adapter.notifyDataSetChanged();
                etItem.setText("");
                selectedPosition = -1;
            } else {
                Toast.makeText(this, "Select item to update", Toast.LENGTH_SHORT).show();
            }
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                itemList.remove(selectedPosition);
                adapter.notifyDataSetChanged();
                etItem.setText("");
                selectedPosition = -1;
            } else {
                Toast.makeText(this, "Select item to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
