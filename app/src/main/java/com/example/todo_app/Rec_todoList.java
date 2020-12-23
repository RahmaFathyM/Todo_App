package com.example.todo_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rec_todoList extends RecyclerView.Adapter<Rec_todoList.ViewHolderTodo> {
    private ArrayList<TodoElement> arrayList;
    private OnClickListener_notes onClickListener_notes;


    public Rec_todoList(Context context, ArrayList<TodoElement> arrayList, OnClickListener_notes onClickListener_notes) {
        this.onClickListener_notes = onClickListener_notes;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolderTodo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recycler_todo_list, null, false);
        ViewHolderTodo viewHolderTodo = new ViewHolderTodo(v);
        return viewHolderTodo;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTodo holder, int position) {
        TodoElement todoElement = arrayList.get(position);
        holder.todoText.setText(todoElement.getTodo_Text());
        holder.todoTime.setText(todoElement.getTodo_Time());
        holder.btn_delete.setImageResource(todoElement.getDelete_btn());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolderTodo extends RecyclerView.ViewHolder {
        TextView todoTime;
        TextView todoText;
        ImageView btn_delete;

        public ViewHolderTodo(@NonNull View view) {
            super(view);
            todoText = view.findViewById(R.id.main_text);
            todoTime = view.findViewById(R.id.time);
            btn_delete = view.findViewById(R.id.btn_delete);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener_notes.onClick(getAdapterPosition());
                }
            });
btn_delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        onClickListener_notes.onClick_image(getAdapterPosition());
    }
});
        }
    }
}
