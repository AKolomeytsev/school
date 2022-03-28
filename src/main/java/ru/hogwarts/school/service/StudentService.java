package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.RepositoryStudent;

import java.util.Collection;

@Service
public class StudentService {
    private final RepositoryStudent repositoryStudent;

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(RepositoryStudent student) {
        this.repositoryStudent = student;
    }

    public Student createStudent(Student student){
        logger.info("Был вызван метод создания студента");
        return repositoryStudent.save(student);
    }

    public Student getStudent(Long id){
        logger.info("Был вызван метод поиска студента по ID = {}",id);
        return repositoryStudent.findById(id).get();
    }

    public Student updateStudent(Student student){
        logger.info("Был вызван метод редактирования информации о студенте {}",student);
        return repositoryStudent.save(student);
    }

    public void deleteStudent(Long id){
        logger.info("Был вызван метод удаления информации о студенте по ID {}",id);
        repositoryStudent.deleteById(id);
    }

    public Collection<Student> getStudentsAge(int age){
        logger.info("Был вызван метод получения списка студентов по возрасту = {}",age);
        return repositoryStudent.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge){
        logger.info("Был вызван метод получения списка студентов по возрасту в промежутке c {} по {}",minAge,maxAge);
        return repositoryStudent.findByAgeBetween(minAge,maxAge);
    }

    public int getCountStudent(){
        logger.info("Был вызван метод получения количества студентов");
        return repositoryStudent.getCountStudent();
    }

    public int getAvgAgeStudent(){
        logger.info("Был вызван метод получения среднего возраста студентов");
        return repositoryStudent.getAvgAgeStudent();
    }

    public Collection<Student> getFiveLastStudent(){
        logger.info("Был вызван метод получения списка из 5 студетов");
        return repositoryStudent.getFiveLastStudent();
    }
}
