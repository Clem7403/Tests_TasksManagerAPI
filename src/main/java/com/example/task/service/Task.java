package com.example.task.service;

public class Task {

    public enum Status {
        EN_COURS,
        TERMINE
    }

    private static int idCounter = 1;
    private int id;
    private Status status;
    private String description;

    public Task(String description){
        this.id = idCounter++;
        this.status = Status.EN_COURS;
        this.description = description;
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public Status getStatus(){
        return status;
    }

    public void markAsDone(){
        this.status = Status.TERMINE;
    }
}
