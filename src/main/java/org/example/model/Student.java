package org.example.model;

import org.example.Grade;

public class Student {
    private int id;
    private String name;
    private int age;
    private Grade grade;

    public Student() {
    }

    public Student(int id, String name, int age, Grade grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }



    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id + "," + name + "," + age + "," + grade;
    }
}
