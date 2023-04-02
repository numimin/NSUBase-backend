package com.github.numi;

import com.github.numi.entities.GroupEntity;
import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;
import com.github.numi.json.Group;
import com.github.numi.json.Student;
import com.github.numi.json.StudentsQuery;
import com.github.numi.repositories.GroupRepository;
import com.github.numi.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class NSUBaseApplication {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    public NSUBaseApplication(StudentRepository studentRepository,
                              GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;

        GroupEntity group20201 = new GroupEntity("20201");
        groupRepository.save(group20201);
        GroupEntity group20202 = new GroupEntity("20202");
        groupRepository.save(group20202);
        studentRepository.save(new StudentEntity(
                "Сергей", "Геря", "Артемович",
                LocalDate.of(2002, 1, 1),
                Gender.MALE, false,
                5000,
                group20201
        ));
    }

    @PostMapping("/api/students")
    public List<Student> students(@RequestParam(required = false) Gender gender,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) Boolean hasChildren,
                                  @RequestParam(required = false) Integer minScholarship,
                                  @RequestParam(required = false) Integer maxScholarship,
                                  @RequestBody()StudentsQuery query) {
        Set<StudentEntity> entities = new HashSet<>();
        if (query.getGroups() == null || query.getGroups().length == 0) {
            entities = studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, null);
        } else {
            for (long groupId: query.getGroups()) {
                Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
                if (groupEntity.isPresent()) {
                    entities.addAll(studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, groupEntity.get()));
                }
            }
        }

        if (entities == null) return new ArrayList<>();
        return entities.stream().map(Student::new).toList();
    }

    @GetMapping("/api/groups")
    public List<Group> groups() {
        List<GroupEntity> entities = groupRepository.findGroups();
        if (entities == null) return new ArrayList<>();
        return entities.stream().map(Group::new).toList();
    }

    @GetMapping("/api/group")
    public Group group(@RequestParam Long id) {
        Optional<GroupEntity> entity = groupRepository.findById(id);
        return entity.map(Group::new).orElse(null);
    }
}
