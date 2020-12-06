package com.example.todo_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rec_todoList extends RecyclerView.Adapter<Rec_todoList.ViewHolderTodo> {
    private ArrayList<todoElement> arrayList;

    public Rec_todoList(Context context, ArrayList<todoElement> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolderTodo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_todo_list,null,false);
        ViewHolderTodo viewHolderTodo = new ViewHolderTodo(v);
        return viewHolderTodo;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderTodo holder, int position) {
        todoElement c =  arrayList.get(position);

        holder.todoText.setText(c.getTodo_Text());
holder.todoTime.setText(c.getTodo_Time());
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class ViewHolderTodo extends RecyclerView.ViewHolder{
        TextView todoTime;
        TextView todoText;
    public ViewHolderTodo(@NonNull View view){
        super(view);
       todoText=view.findViewById(R.id.main_text);
       todoTime=view.findViewById(R.id.time);

    }}
}
