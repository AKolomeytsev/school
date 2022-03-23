package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.RepositoryFaculty;

import java.util.Collection;

@Service
public class FacultyService {
    private final RepositoryFaculty repositoryFaculty;

    private Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(RepositoryFaculty faculty) {
        this.repositoryFaculty = faculty;
    }

    public Faculty createFaculty(Faculty faculty){
        logger.info("Был вызван метод создания факультета");
        return repositoryFaculty.save(faculty);
    }

    public Faculty getFaculty(Long id){
        logger.info("Был вызван метод поиска факультета по ID");
        return repositoryFaculty.findById(id).get();
    }

    public Faculty updateFaculty(Faculty faculty){
        logger.info("Был вызван метод редактирования данных факультета");
        return repositoryFaculty.save(faculty);
    }

    public void deleteFaculty(Long id){
        logger.info("Был вызван метод удаления факультета по ID");
        repositoryFaculty.deleteById(id);
    }

    public Collection<Faculty> findByColorIgnoreCaseContains(String color){
        logger.info("Был вызван метод получения списка факультетов по цвету");
        return (Collection<Faculty>) repositoryFaculty.findByColorIgnoreCaseContains(color);
    }

    public Collection<Faculty> findByNameIgnoreCaseContains(String name){
        logger.info("Был вызван метод поиска факультета по названию");
        return (Collection<Faculty>) repositoryFaculty.findByNameIgnoreCaseContains(name);
    }
}
