package com.example.todo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
   Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec);
       btn_add = findViewById(R.id.btn_add);
        RecyclerView.LayoutManager layoutManage;
        recyclerView.setHasFixedSize(true);
        layoutManage = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManage);
        ArrayList<todoElement> todo_Array = new ArrayList<todoElement>();
        todo_Array.add(new todoElement("study", "12:00"));
        todo_Array.add(new todoElement("sleep", "12:30"));
        todo_Array.add(new todoElement("read", "12:20"));
        todo_Array.add(new todoElement("study", "12:11"));
        todo_Array.add(new todoElement("prayer", "12:00"));
        todo_Array.add(new todoElement("sleep", "12:30"));
        todo_Array.add(new todoElement("study", "12:00"));
        todo_Array.add(new todoElement("sleep", "12:30"));
        todo_Array.add(new todoElement("read", "12:20"));
        todo_Array.add(new todoElement("study", "12:11"));
        todo_Array.add(new todoElement("prayer", "12:00"));
        todo_Array.add(new todoElement("sleep", "12:30"));
        Rec_todoList rec_todoList = new Rec_todoList(this, todo_Array);
        recyclerView.setAdapter(rec_todoList);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });
    }

}
