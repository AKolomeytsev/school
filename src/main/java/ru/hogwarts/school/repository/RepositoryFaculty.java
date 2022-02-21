package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface RepositoryFaculty extends JpaRepository<Faculty,Long> {
    Collection<Faculty> findFacultyByNameIgnoreCaseContains(String name);
}
