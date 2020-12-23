package com.example.todo_app;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
EditText et_txnotes;
EditText et_tmnotes;
Button btn_save;
NoteDataBase noteDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        et_txnotes=findViewById(R.id.Et_txnotes);
        et_tmnotes=findViewById(R.id.Et_tmnotes);
        btn_save=findViewById(R.id.btn_save);
        noteDataBase= new NoteDataBase(Add.this);
        Intent data = getIntent();
        String string = data.getExtras().getString("text");
        String string2 = data.getExtras().getString("time");
       et_tmnotes .setText(string2);
       et_txnotes.setText(string);

        btn_save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String todoText=et_txnotes.getText().toString();
               String todoTime=et_tmnotes.getText().toString();
               TodoElement todoElement=new TodoElement(todoText,todoTime);
            noteDataBase.insertNote(todoElement);

               startActivity(new Intent(Add.this,MainActivity.class));
           }
       });

    }
}
