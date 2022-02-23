package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.RepositoryStudent;

import java.util.Collection;

@Service
public class StudentService {
    private final RepositoryStudent repositoryStudent;

    public StudentService(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    public Student createStudent(Student student){
        return repositoryStudent.save(student);
    }

    public Student getStudent(Long id){
        return repositoryStudent.findById(id).get();
    }

    public Student updateStudent(Student student){
        return repositoryStudent.save(student);
    }

    public void deleteStudent(Long id){
        repositoryStudent.deleteById(id);
    }

    public Collection<Student> getStudentsAge(int age){
        return repositoryStudent.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge){
        return repositoryStudent.findByAgeBetween(minAge,maxAge);
    }
}
