package com.tiy.practice;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.Serializable;

/**
 * Created by crci1 on 12/24/2016.
 */
public class ToDoItem implements Serializable {
    String task;
    boolean completed;

    public ToDoItem(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public ToDoItem(Object todoitem) {

    }

    public String toString() {
        if (isCompleted()) {
            return task + " (completed)";
        } else {
            return task;
        }
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
