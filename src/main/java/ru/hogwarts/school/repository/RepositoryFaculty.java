package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

public interface RepositoryFaculty extends JpaRepository<Faculty,Long> {
}
