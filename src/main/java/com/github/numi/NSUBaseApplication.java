package com.github.numi;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.enums.Gender;
import com.github.numi.students.json.*;
import com.github.numi.students.repositories.FacultyRepository;
import com.github.numi.students.repositories.GroupRepository;
import com.github.numi.students.repositories.StudentRepository;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;
import com.github.numi.teachers.json.*;
import com.github.numi.teachers.repositories.DepartmentRepository;
import com.github.numi.teachers.repositories.TeacherRepository;
import com.github.numi.utils.DateStruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class NSUBaseApplication {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final FacultyRepository facultyRepository;
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    public NSUBaseApplication(StudentRepository studentRepository,
                              GroupRepository groupRepository,
                              FacultyRepository facultyRepository,
                              TeacherRepository teacherRepository,
                              DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.facultyRepository = facultyRepository;
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;

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

        DepartmentEntity si = new DepartmentEntity("СИ", fit);
        departmentRepository.save(si);
        DepartmentEntity kt = new DepartmentEntity("КТ", fit);
        departmentRepository.save(kt);

        teacherRepository.save(new TeacherEntity("Александр", "Кугаевских", "",
                Category.ASSISTANT_PROFESSOR, Gender.MALE, false, 50000,
                false, LocalDate.of(2013, 12, 5), kt,
                "Теория поля", null));
    }

    private static <T, U, R> Set<R> retrieveAll(List<Optional<T>> lhs, List<Optional<U>> rhs, BiFunction<T, U, Set<R>> function) {
        Set<R> entities = new HashSet<>();
        if (lhs == null || lhs.size() == 0) {
            if (rhs == null || rhs.size() == 0) {
                return function.apply(null, null);
            } else {
                for (Optional<U> r: rhs) {
                    r.ifPresent(u -> entities.addAll(function.apply(null, u)));
                }
            }
        } else {
            if (rhs == null || rhs.size() == 0) {
                for (Optional<T> l: lhs) {
                    l.ifPresent(t -> entities.addAll(function.apply(t, null)));
                }
            } else {
                for (Optional<T> l: lhs) {
                    for (Optional<U> r: rhs) {
                        if (l.isPresent() && r.isPresent()) {
                            entities.addAll(function.apply(l.get(), r.get()));
                        }
                    }
                }
            }
        }
        return entities;
    }

    @PostMapping("/api/students")
    public List<Student> students(@RequestParam(required = false) Gender gender,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) Boolean hasChildren,
                                  @RequestParam(required = false) Integer minScholarship,
                                  @RequestParam(required = false) Integer maxScholarship,
                                  @RequestBody() StudentsQuery query) {
        Set<StudentEntity> entities = retrieveAll(
                query.getGroups() == null ? null : Arrays.stream(query.getGroups())
                        .map(groupRepository::findById)
                        .toList(),
                query.getFaculties() == null ? null : Arrays.stream(query.getFaculties())
                        .map(facultyRepository::findById)
                        .toList(),
                (group, faculty) -> studentRepository.findStudent(
                        gender, year, age, hasChildren,
                        minScholarship, maxScholarship,
                        group, faculty));

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

    @GetMapping("/api/department")
    public Department department(@RequestParam Long id) {
        Optional<DepartmentEntity> entity = departmentRepository.findById(id);
        return entity.map(Department::new).orElse(null);
    }

    @PostMapping("/api/departments")
    public List<Department> departments(@RequestBody DepartmentsQuery query) {
        Set<DepartmentEntity> entities = new HashSet<>();
        if (query.getFaculties().length == 0) {
            entities.addAll(departmentRepository.findDepartments());
        } else {
            for (long facultyId: query.getFaculties()) {
                Optional<FacultyEntity> entity = facultyRepository.findById(facultyId);
                entity.ifPresent(faculty -> entities.addAll(departmentRepository.findDepartments(faculty)));
            }
        }
        return entities.stream().map(Department::new).toList();
    }

    private static LocalDate convertDate(DateStruct dateStruct) {
        if (dateStruct.year < 0 || dateStruct.month < 0 || dateStruct.day < 0) return null;
        try {
            return LocalDate.of(dateStruct.year, dateStruct.month, dateStruct.day);
        } catch (DateTimeException e) {
            return null;
        }
    }
    @PostMapping("/api/teachers")
    public List<Teacher> teachers(@RequestParam(required = false) Category category,
                                  @RequestParam(required = false) Gender gender,
                                  @RequestParam(required = false) Boolean hasChildren,
                                  @RequestParam(required = false) Integer minSalary,
                                  @RequestParam(required = false) Integer maxSalary,
                                  @RequestParam(required = false) Boolean graduateStudent,
                                  @RequestBody TeachersQuery query) {
        Set<TeacherEntity> entities = retrieveAll(Arrays.stream(query.getFaculties())
                        .map(facultyRepository::findById)
                        .toList(),
                Arrays.stream(query.getDepartments())
                        .map(departmentRepository::findById)
                        .toList(),
                (faculty, department) -> teacherRepository.findTeachers(
                    category, gender, hasChildren, minSalary, maxSalary,
                        graduateStudent, convertDate(query.getPhdThesisStartDate()),
                        convertDate(query.getPhdThesisEndDate()),
                        department, faculty));
        if (entities == null) return new ArrayList<>();
        return entities.stream().map(Teacher::new).toList();
    }

    @PostMapping("/api/dissertations")
    public List<String> dissertations(@RequestBody DissertationsQuery query) {
        Set<TeacherEntity> entities = retrieveAll(Arrays.stream(query.getFaculties())
                        .map(facultyRepository::findById)
                        .toList(),
                Arrays.stream(query.getDepartments())
                        .map(departmentRepository::findById)
                        .toList(),
                (faculty, department) -> teacherRepository
                        .findTeachersByAffinity(department, faculty));
        if (entities == null) return new ArrayList<>();
        return Stream.concat(entities.stream().map(TeacherEntity::getDoctoralDissertation),
                         entities.stream().map(TeacherEntity::getPhdDissertation))
                .toList();
    }
}
