package com.github.numi;

import com.github.numi.entities.FacultyEntity;
import com.github.numi.entities.GroupEntity;
import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;
import com.github.numi.json.*;
import com.github.numi.repositories.FacultyRepository;
import com.github.numi.repositories.GroupRepository;
import com.github.numi.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class NSUBaseApplication {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final FacultyRepository facultyRepository;

    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    public NSUBaseApplication(StudentRepository studentRepository,
                              GroupRepository groupRepository,
                              FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.facultyRepository = facultyRepository;

        FacultyEntity fen = new FacultyEntity("ФЕН");
        facultyRepository.save(fen);
        FacultyEntity fit = new FacultyEntity("ФИТ");
        facultyRepository.save(fit);
        GroupEntity group20201 = new GroupEntity("20201", fit);
        groupRepository.save(group20201);
        GroupEntity group20202 = new GroupEntity("20202", fit);
        groupRepository.save(group20202);
        GroupEntity group22404_1 = new GroupEntity("22404.1", fen);
        groupRepository.save(group22404_1);
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
            if (query.getFaculties() == null || query.getFaculties().length == 0) {
                entities = studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, null, null);
            } else {
                for (long facultyId: query.getFaculties()) {
                    Optional<FacultyEntity> facultyEntity = facultyRepository.findById(facultyId);
                    if (facultyEntity.isPresent()) {
                        entities.addAll(studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, null, facultyEntity.get()));
                    }
                }
            }
        } else {
            if (query.getFaculties() == null || query.getFaculties().length == 0) {
                for (long groupId: query.getGroups()) {
                    Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
                    if (groupEntity.isPresent()) {
                        entities.addAll(studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, groupEntity.get(), null));
                    }
                }
            } else {
                for (long groupId: query.getGroups()) {
                    Optional<GroupEntity> groupEntity = groupRepository.findById(groupId);
                    for (long facultyId: query.getFaculties()) {
                        Optional<FacultyEntity> facultyEntity = facultyRepository.findById(facultyId);
                        if (groupEntity.isPresent() && facultyEntity.isPresent()) {
                            entities.addAll(studentRepository.findStudent(gender, year, age, hasChildren, minScholarship, maxScholarship, groupEntity.get(), facultyEntity.get()));
                        }
                    }
                }
            }
        }

        if (entities == null) return new ArrayList<>();
        return entities.stream().map(Student::new).toList();
    }

    @PostMapping("/api/groups")
    public List<Group> groups(@RequestBody GroupQuery query) {
        Set<GroupEntity> entities = new HashSet<>();
        if (query.getFaculties().length == 0) {
            entities.addAll(groupRepository.findGroups());
        } else {
            for (long facultyId: query.getFaculties()) {
                Optional<FacultyEntity> entity = facultyRepository.findById(facultyId);
                entity.ifPresent(faculty -> entities.addAll(groupRepository.findGroups(faculty)));
            }
        }
        return entities.stream().map(Group::new).toList();
    }

    @GetMapping("/api/group")
    public Group group(@RequestParam Long id) {
        Optional<GroupEntity> entity = groupRepository.findById(id);
        return entity.map(Group::new).orElse(null);
    }

    @GetMapping("/api/faculties")
    public List<Faculty> faculties() {
        List<FacultyEntity> entities = facultyRepository.findFaculties();
        if (entities == null) return new ArrayList<>();
        return entities.stream().map(Faculty::new).toList();
    }

    @GetMapping("/api/faculty")
    public Faculty faculty(@RequestParam Long id) {
        Optional<FacultyEntity> entity = facultyRepository.findById(id);
        return entity.map(Faculty::new).orElse(null);
    }
}
