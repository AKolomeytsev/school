package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface RepositoryFaculty extends JpaRepository<Faculty,Long> {
    Collection<Faculty> findByNameIgnoreCaseContains(String name);
    Collection<Faculty> findByColorIgnoreCaseContains(String color);
}
