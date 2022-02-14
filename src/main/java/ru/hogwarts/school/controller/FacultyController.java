package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }


    @GetMapping("{id}")
    public Faculty getStudent(@PathVariable Long id){
        return facultyService.getFaculty(id);
    }
    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping
    public Faculty updateStudent(@RequestBody Faculty faculty){
        return facultyService.updateFaculty(faculty);
    }
    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping(path = "color/{color}")
    public Collection<Faculty> getFacultyColor(@PathVariable String color){
        return facultyService.getFacultyColor(color);
    }
}
