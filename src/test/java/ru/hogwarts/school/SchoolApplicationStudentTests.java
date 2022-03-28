package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

import static java.lang.String.valueOf;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class SchoolApplicationStudentTests {
    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Student student;
    private long studentId;

    @BeforeEach
    void initTestData() {
        student = new Student();
        student.setId(1L);
        student.setName("student10");
        student.setAge(39);
    }

    @Test
    void contextLoads() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    void testGetStudent() throws Exception{
        StringBuilder urlString = new StringBuilder("http://localhost:" + port + "/" +"students/1");
        Assertions.assertThat(this.testRestTemplate.getForObject(urlString.toString(),
                String.class)).isNotNull();
    }

    @Test
    void testCreateStudent() throws Exception{
        String urlString = "http://localhost:" + port + "/" +"students/";
        Assertions.assertThat(this.testRestTemplate.postForObject(urlString, student, String.class)).isNotNull();
    }

    @Test
    void testFindByAgeBetween() throws Exception{
        String urlString = "http://localhost:" + port + "/students/filter?minAge=10&maxAge=30";
        Assertions.assertThat(this.testRestTemplate.getForObject(urlString,String.class)).isNotNull();
    }

    @Test
    void testGetStudentAge() throws Exception{
        String urlString = "http://localhost:" + port + "/students/age/24";
        Assertions.assertThat(this.testRestTemplate.getForObject(urlString,String.class)).isNotNull();
    }

    @Test
    void putStudentTest() {
        String urlString = "http://localhost:" + port + "/" +"students/";
        student.setAge(100);

        studentId = testRestTemplate.postForObject(urlString, student, Student.class).getId();

        student.setId(studentId);

        testRestTemplate.put(urlString, student);

        Assertions
                .assertThat(this.testRestTemplate.getForObject(urlString + studentId, Student.class))
                .isEqualTo(student);
    }

    @Test
    void deleteStudentTest() {
        String urlString = "http://localhost:" + port + "/" +"students/";
        studentId = testRestTemplate.postForObject(urlString, student, Student.class).getId();
        student.setId(studentId);
        testRestTemplate.delete(urlString + studentId);

        Assertions
                .assertThat(this.testRestTemplate.getForObject(urlString + studentId, Student.class))
                .isNotIn(student);
    }
}
