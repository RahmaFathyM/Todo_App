package com.example.todo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btn_add;
    NoteDataBase noteDataBase;
    ArrayList<TodoElement> todo_Array;
    Rec_todoList rec_todoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec);
        noteDataBase = new NoteDataBase(MainActivity.this);
        btn_add = findViewById(R.id.btn_add);
        RecyclerView.LayoutManager layoutManage;
        recyclerView.setHasFixedSize(true);
        layoutManage = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManage);
        todo_Array = new ArrayList<>();
        todo_Array = noteDataBase.getAllNotes();
        rec_todoList = new Rec_todoList(this, todo_Array, new OnClickListener_notes() {
            @Override
            public void onClick(int id) {
                TodoElement todoElement = todo_Array.get(id);
                Intent i = new Intent(MainActivity.this, Add.class);
                i.putExtra("text", todoElement.getTodo_Text());
                i.putExtra("time", todoElement.getTodo_Time());
                startActivity(i);
            }

            @Override
            public void onClick_image(int i) {

                noteDataBase.deleteNote(todo_Array.get(i).getTodo_id());
//                Toast.makeText(MainActivity.this,"delete" +todo_Array.get(i).getTodo_id(),Toast.LENGTH_SHORT).show();
                todo_Array.remove(todo_Array.get(i));
                rec_todoList.notifyItemRemoved(i);
                rec_todoList.notifyDataSetChanged();

            }
        });
        recyclerView.setAdapter(rec_todoList);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Add.class);
                intent.putExtra("text", "");
                intent.putExtra("time", "");
                startActivity(intent);
                startActivity(intent);
            }
        });
    }

}
