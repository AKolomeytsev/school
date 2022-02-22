package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface RepositoryStudent extends JpaRepository<Student,Long> {
    Collection<Student> findByAgeBetween(int minAge, int maxAge);
}
