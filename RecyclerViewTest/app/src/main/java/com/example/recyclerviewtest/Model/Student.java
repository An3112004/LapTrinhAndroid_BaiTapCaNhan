package com.example.recyclerviewtest.Model;

public class Student {
    private String name;
    private int age;
    private String classroom;

    public Student(String name, int age, String classroom) {
        this.name = name;
        this.age = age;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassroom() {
        return classroom;
    }

}
