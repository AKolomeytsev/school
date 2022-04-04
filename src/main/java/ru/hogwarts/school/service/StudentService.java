package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.RepositoryStudent;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final RepositoryStudent repositoryStudent;

    public StudentService(RepositoryStudent student) {
        this.repositoryStudent = student;
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

    public int getCountStudent(){
        return repositoryStudent.getCountStudent();
    }

    public int getAvgAgeStudent(){
        return repositoryStudent.getAvgAgeStudent();
    }

    public Collection<Student> getFiveLastStudent(){
        return repositoryStudent.getFiveLastStudent();
    }

    public Collection<String> getStudentByFirstLetter(String chr){
        Collection<Student> students = repositoryStudent.findAll();
        return students.stream().map(Student::getName).filter(s -> s.substring(0,1).toUpperCase().equals(chr.toUpperCase())).map(s -> s.toUpperCase()).sorted().toList();
    }

    public int getAgeStudentStream() {
        Collection<Student> students = repositoryStudent.findAll();
        int count = students.size();
        return (int)students.stream().reduce(0,(x,y)->{
            x += y.getAge();
            return x;
        },
                (x,y)->x)/count;
    }

    public void getStudentsSomeStreams() {
        List<Student> students = repositoryStudent.findAll();
        printStudent(students.get(0));
        printStudent(students.get(1));

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                printStudent(students.get(2));
                printStudent(students.get(3));

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                printStudent(students.get(4));
                printStudent(students.get(5));
            }
        };
        thread1.start();
        thread2.start();


    }
    public void printStudent(Student student) {
        System.out.println(student.toString());
    }
    public synchronized void printSynchStudent(Student student) {

        System.out.println(student.toString());
    }

    public void getStudentsSomeSynhStreams() {
        List<Student> students = repositoryStudent.findAll();
        printSynchStudent(students.get(0));
        printSynchStudent(students.get(1));

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                printSynchStudent(students.get(2));
                printSynchStudent(students.get(3));

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                printSynchStudent(students.get(4));
                printSynchStudent(students.get(5));
            }
        };
        thread1.start();
        thread2.start();
    }
}
