package com.example.TaskManager.model;

import java.time.LocalDate;

public class Task {
    private int t_Id;
    private String t_Title;
    private LocalDate dueDate;
    private String description;
    private boolean completed;

    public Task( String t_Title, LocalDate dueDate, String description) {
        this.t_Title = t_Title;
        this.dueDate = dueDate;
        this.description = description;
    }

    public int  getT_Id() {
        return t_Id;
    }

    public void setT_Id(int t_Id) {
        this.t_Id = t_Id;
    }

    public String getT_Title() {
        return t_Title;
    }

    public void setT_Title(String t_Title) {
        this.t_Title = t_Title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
