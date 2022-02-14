package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final HashMap<Long, Student> students = new HashMap<Long, Student>();
    private Long id = 0l;

    public Student createStudent(Student student){
        student.setId(++id);
        students.put(student.getId(),student);
        return student;
    }
    public Student getStudent(Long id){
        return students.get(id);
    }
    public Student updateStudent(Student student){
        students.put(student.getId(),student);
        return student;
    }
    public Student deleteStudent(Long id){
        return students.remove(id);
    }
    public Collection<Student> getStudentsAge(int age){
        return students.values().stream().filter(student -> student.getAge() == age ).toList();
    }
}
