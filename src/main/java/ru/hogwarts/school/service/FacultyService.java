package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultys = new HashMap<Long, Faculty>();
    private Long id = 0l;

    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++id);
        facultys.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty getFaculty(Long id){
        return facultys.get(id);
    }
    public Faculty updateFaculty(Faculty faculty){
        facultys.put(faculty.getId(),faculty);
        return faculty;
    }
    public Faculty deleteFaculty(Long id){
        return facultys.remove(id);
    }
    public Collection<Faculty> getFacultyColor(String color){
        return facultys.values().stream().filter(faculty -> faculty.getColor().equals(color) ).toList();
    }
}
