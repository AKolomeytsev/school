package ru.hogwarts.school.model;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String nane;
    private int age;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Student(long id, String nane, int age, int faculty) {
        this.id = id;
        this.nane = nane;
        this.age = age;
    }

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
