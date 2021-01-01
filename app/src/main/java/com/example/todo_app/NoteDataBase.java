package com.example.todo_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteDataBase extends SQLiteOpenHelper {
    public static final String DB_Name = "note_db";
    public static final int DB_Version = 5;
    public static final String tb_name = "Notes";
    public static final String CLN_notes = "text";
    public static final String CLN_time = "time";
    public static final String CLN_id = "id";
    public NoteDataBase(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + tb_name + "(" + CLN_notes + " TEXT ," + CLN_time + " TEXT , " + CLN_id +" integer  primary key Autoincrement )" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tb_name);
        onCreate(db);

    }

    public void insertNote(TodoElement todoElement) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CLN_notes, todoElement.getTodo_Text());
        values.put(CLN_time, todoElement.getTodo_Time());
         db.insert( tb_name ,null, values);

    }

    public ArrayList <TodoElement> getAllNotes() {
        ArrayList<TodoElement> todoElementArrayList = new ArrayList<TodoElement>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tb_name, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String textNote = cursor.getString(cursor.getColumnIndex(CLN_notes));
                String timetNote = cursor.getString(cursor.getColumnIndex(CLN_time));
                int id=cursor.getInt(cursor.getColumnIndex(CLN_id));
                TodoElement todoElement = new TodoElement(textNote, timetNote,id);
                todoElementArrayList.add(todoElement);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return todoElementArrayList;
    }

public int deleteNote(int id){
        SQLiteDatabase db=getWritableDatabase();
       String args []={String.valueOf(id)};
      int r=  db.delete(tb_name, CLN_id + "=? ",args);
   return r;
}
}
