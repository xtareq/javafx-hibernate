package com.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String class_name;
    private int roll;

    public Student()
    {

    }
    public Student(long id, String name, String class_name, int roll) {
        this.id = id;
        this.name = name;
        this.class_name = class_name;
        this.roll = roll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
}
