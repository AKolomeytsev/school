package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public Faculty getStudent(@PathVariable long id){
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
    public ResponseEntity deleteStudent(@PathVariable long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "color/{color}")
    public ResponseEntity<Collection<Faculty>> getFacultyColor(@PathVariable String color){
        Collection<Faculty> faculties = facultyService.findByColorIgnoreCaseContains(color);
        return ResponseEntity.ok(faculties);
    }

    @GetMapping(path = "filter")
    public ResponseEntity<Collection<Faculty>> findFacultyByNameIgnoreCaseContains(String name){
        Collection<Faculty> faculties = facultyService.findByNameIgnoreCaseContains(name);
        return ResponseEntity.ok(faculties);
    }

    @GetMapping(path = "maxLenName")
    public ResponseEntity<Optional<Map.Entry<Integer, List<String>>>> getMaxLenName(){
        Optional<Map.Entry<Integer, List<String>>> facultName = facultyService.getMaxLenName();
        return ResponseEntity.ok(facultName);
    }
}
