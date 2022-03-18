package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.RepositoryFaculty;

import java.util.Collection;

@Service
public class FacultyService {
    private final RepositoryFaculty repositoryFaculty;

    public FacultyService(RepositoryFaculty faculty) {
        this.repositoryFaculty = faculty;
    }

    public Faculty createFaculty(Faculty faculty){
        return repositoryFaculty.save(faculty);
    }

    public Faculty getFaculty(Long id){
        return repositoryFaculty.findById(id).get();
    }

    public Faculty updateFaculty(Faculty faculty){
        return repositoryFaculty.save(faculty);
    }

    public void deleteFaculty(Long id){
        repositoryFaculty.deleteById(id);
    }

    public Collection<Faculty> findByColorIgnoreCaseContains(String color){
        return (Collection<Faculty>) repositoryFaculty.findByColorIgnoreCaseContains(color);
    }

    public Collection<Faculty> findByNameIgnoreCaseContains(String name){
        return (Collection<Faculty>) repositoryFaculty.findByNameIgnoreCaseContains(name);
    }
}
