package com.github.numi;

import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;
import com.github.numi.json.Student;
import com.github.numi.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class NSUBaseApplication {
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    public NSUBaseApplication(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentRepository.save(new StudentEntity(
                "Сергей", "Геря", "Артемович",
                LocalDate.of(2002, 1, 1),
                Gender.MALE, false,
                5000
        ));
    }

    @GetMapping("/api/student")
    public Student studentByFirstname(@RequestParam String firstname) {
        StudentEntity entity = studentRepository.findByFirstname(firstname);
        if (entity == null) return null;
        return new Student(entity);
    }
}
