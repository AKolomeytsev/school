package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface RepositoryStudent extends JpaRepository<Student,Long> {
    Collection<Student> findByAgeBetween(int minAge, int maxAge);
    Collection<Student> findByAge(int age);
    @Query(value = "SELECT COUNT(*) as cnt FROM student",nativeQuery = true)
    int getCountStudent();
    @Query(value = "SELECT AVG(age) as AvgAge FROM student",nativeQuery = true)
    int getAvgAgeStudent();
    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5",nativeQuery = true)
    Collection<Student> getFiveLastStudent();
}
