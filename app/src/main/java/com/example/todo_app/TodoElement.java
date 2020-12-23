package com.example.todo_app;

public class TodoElement {
    private String todo_Text;
    private String todo_Time;
private int delete_btn;

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    private int todo_id;
    public int getDelete_btn() {
        return delete_btn;
    }

    public void setDelete_btn(int delete_btn) {
        this.delete_btn = delete_btn;
    }

    public String getTodo_Text() {
        return todo_Text;
    }

    public void setTodo_Text(String todo_Text) {
        this.todo_Text = todo_Text;
    }

    public String getTodo_Time() {
        return todo_Time;
    }

    public TodoElement(String todo_Text, String todo_Time) {
        this.todo_Text = todo_Text;
        this.todo_Time = todo_Time;
    }

    public void setTodo_Time(String todo_Time) {
        this.todo_Time = todo_Time;
    }
}
