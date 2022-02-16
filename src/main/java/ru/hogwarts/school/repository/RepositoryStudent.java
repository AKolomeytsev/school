package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

public interface RepositoryStudent extends JpaRepository<Student,Long> {
}
