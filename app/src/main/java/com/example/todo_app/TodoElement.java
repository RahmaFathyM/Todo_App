package com.example.todo_app;

public class todoElement {
    private String todo_Text;
    private String todo_Time;

    public String getTodo_Text() {
        return todo_Text;
    }

    public void setTodo_Text(String todo_Text) {
        this.todo_Text = todo_Text;
    }

    public String getTodo_Time() {
        return todo_Time;
    }

    public todoElement(String todo_Text, String todo_Time) {
        this.todo_Text = todo_Text;
        this.todo_Time = todo_Time;
    }

    public void setTodo_Time(String todo_Time) {
        this.todo_Time = todo_Time;
    }
}
