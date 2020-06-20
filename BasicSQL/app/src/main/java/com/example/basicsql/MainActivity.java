package com.example.basicsql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button add_data;
    EditText add_name;
    ListView user_list;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        listItem = new ArrayList<>();

        user_list = findViewById(R.id.user_list); // Going to add the data to this listview
        add_data = findViewById(R.id.add_data); // add_data is id of the button, we give it a same name anyway
        add_name = findViewById(R.id.add_name); // R.id.add_name -> add_name is id of the edittext view

        viewData();

        user_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = user_list.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });


        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = add_name.getText().toString();
                if(!name.equals("") && db.insertData(name)){
                    Toast.makeText(MainActivity.this, "Data Added " + name , Toast.LENGTH_SHORT).show();
                    add_name.setText("");
                    listItem.clear(); // Clear the list to show new database status
                    viewData();
                }
                else{
                    Toast.makeText(MainActivity.this, "Problem accured!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void viewData() {
        Cursor cursor = db.viewData();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data added yet", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                listItem.add(cursor.getString(1)); // 1 is the index of the name, 0 is id if you want to get id
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            user_list.setAdapter(adapter);
        }
    }
}