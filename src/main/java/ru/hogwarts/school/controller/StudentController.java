package ru.hogwarts.school.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable PageRequest id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("filter")
    public ResponseEntity<Collection<Student>> findByAgeBetween(@RequestParam int minAge, int maxAge){
        Collection<Student> students = studentService.findByAgeBetween(minAge,maxAge);
        return ResponseEntity.ok(students);
    }

    @GetMapping(path = "age/{age}")
    public ResponseEntity<Collection<Student>> getStudentAge(@PathVariable int age){
        Collection<Student> students = studentService.getStudentsAge(age);
        return ResponseEntity.ok(students);
    }

    @GetMapping("CountStudent")
    public int getCountStudent(){
        return studentService.getCountStudent();
    }

    @GetMapping("AvgAgeStudent")
    public int getAvgAgeStudent(){
        return studentService.getAvgAgeStudent();
    }

    @GetMapping("FiveLastStudent")
    public ResponseEntity<Collection<Student>> getFiveLastStudent(){
        Collection<Student> students = studentService.getFiveLastStudent();
        return ResponseEntity.ok(students);
    }
}
