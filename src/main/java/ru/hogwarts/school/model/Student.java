package ru.hogwarts.school.model;

public class Student {
    private Long id;
    private String nane;
    private int age;

    public Student(long id, String nane, int age) {
        this.id = id;
        this.nane = nane;
        this.age = age;
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
