package com.github.numi;

import com.github.numi.add.AddGroupBody;
import com.github.numi.add.AddStudentBody;
import com.github.numi.add.AddTeacherBody;
import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.students.entities.MarkEntity;
import com.github.numi.students.entities.StudentEntity;
import com.github.numi.students.enums.Gender;
import com.github.numi.students.json.*;
import com.github.numi.students.repositories.FacultyRepository;
import com.github.numi.students.repositories.GroupRepository;
import com.github.numi.students.repositories.MarkRepository;
import com.github.numi.students.repositories.StudentRepository;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.GraduateWorkEntity;
import com.github.numi.teachers.entities.LessonEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;
import com.github.numi.teachers.enums.LessonType;
import com.github.numi.teachers.json.*;
import com.github.numi.teachers.repositories.DepartmentRepository;
import com.github.numi.teachers.repositories.GraduateWorkRepository;
import com.github.numi.teachers.repositories.LessonRepository;
import com.github.numi.teachers.repositories.TeacherRepository;
import com.github.numi.utils.DateStruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@PropertySource("classpath:application.properties")
@RestController
public class NSUBaseApplication {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final FacultyRepository facultyRepository;
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    private final LessonRepository lessonRepository;
    private final MarkRepository markRepository;
    private final GraduateWorkRepository graduateWorkRepository;
    public static void main(String[] args) {
        SpringApplication.run(com.github.numi.NSUBaseApplication.class, args);
    }

    public NSUBaseApplication(StudentRepository studentRepository,
                              GroupRepository groupRepository,
                              FacultyRepository facultyRepository,
                              TeacherRepository teacherRepository,
                              DepartmentRepository departmentRepository,
                              LessonRepository lessonRepository,
                              MarkRepository markRepository,
                              GraduateWorkRepository graduateWorkRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.facultyRepository = facultyRepository;
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.lessonRepository = lessonRepository;
        this.markRepository = markRepository;
        this.graduateWorkRepository = graduateWorkRepository;

        /*FacultyEntity fit = new FacultyEntity("ФИЗФАК");
        facultyRepository.save(fit);
        GroupEntity group20201 = new GroupEntity("20203", LocalDate.of(2020, 8, 31), fit);
        groupRepository.save(group20201);
        GroupEntity group20202 = new GroupEntity("20204", LocalDate.of(2020, 8, 31), fit);
        groupRepository.save(group20202);

        DepartmentEntity si = new DepartmentEntity("Экспериментальная физика", fit);
        departmentRepository.save(si);
        DepartmentEntity kt = new DepartmentEntity("Теоретическая физика", fit);
        departmentRepository.save(kt);

        Random rand = new Random();
        var firstnames = Arrays.asList("Юрий", "Егор", "Дмитрий", "Иван", "Роман");
        var lastnames = Arrays.asList("Колюжнов", "Парфенов", "Пальчунов", "Иванов", "Дмитриевский");
        var patronymics = Arrays.asList("Юрьевич", "Егорович", "Дмитриевич", "Иванович", "Романович");
        for (var firstname : firstnames) {
            for (var lastname: lastnames) {
                for (var patronymic : patronymics) {
                    studentRepository.save(new StudentEntity(
                            firstname, lastname, patronymic,
                            LocalDate.of(2002, rand.nextInt(12) + 1, rand.nextInt(28) + 1),
                            rand.nextInt(2) == 0 ? Gender.FEMALE : Gender.MALE,
                            rand.nextInt(2) == 0,
                            rand.nextInt(5000),
                            rand.nextInt(2) == 0 ? group20201 : group20202
                    ));
                }
            }
        }

        for (var firstname : firstnames) {
            for (var lastname: lastnames) {
                for (var patronymic : patronymics) {
                    teacherRepository.save(new TeacherEntity(
                            firstname, lastname, patronymic,
                            rand.nextInt(3) == 0 ? Category.ASSISTANT : rand.nextInt(2) == 0 ? Category.ASSISTANT_PROFESSOR : Category.PROFESSOR,
                            rand.nextInt(2) == 0 ? Gender.FEMALE : Gender.MALE,
                            rand.nextInt(2) == 0,
                            rand.nextInt(10000) + 15000,
                            rand.nextInt(2) == 0,
                            LocalDate.of(2013, rand.nextInt(12) + 1, rand.nextInt(28) + 1),
                            rand.nextInt(2) == 0 ? kt : si,
                            null,
                            null
                    ));
                }
            }
        }*/

        /*FacultyEntity fen = new FacultyEntity("ФЕН");
        facultyRepository.save(fen);
        FacultyEntity fit = new FacultyEntity("ФИТ");
        facultyRepository.save(fit);

        GroupEntity group20201 = new GroupEntity("20201", LocalDate.of(2020, 8, 31), fit);
        groupRepository.save(group20201);
        GroupEntity group20202 = new GroupEntity("20202", LocalDate.of(2020, 8, 31), fit);
        groupRepository.save(group20202);
        GroupEntity group22404_1 = new GroupEntity("22404.1", LocalDate.of(2022, 8, 31), fen);
        groupRepository.save(group22404_1);

        StudentEntity sadriev = new StudentEntity(
                "Сергей", "Геря", "Артемович",
                LocalDate.of(2002, 1, 1),
                Gender.MALE, false,
                5000,
                group20201
        );
        studentRepository.save(sadriev);

        DepartmentEntity si = new DepartmentEntity("СИ", fit);
        departmentRepository.save(si);
        DepartmentEntity kt = new DepartmentEntity("КТ", fit);
        departmentRepository.save(kt);

        TeacherEntity kugaevskikh = new TeacherEntity("Александр", "Кугаевских", "",
                Category.ASSISTANT_PROFESSOR, Gender.MALE, false, 50000,
                false, LocalDate.of(2013, 12, 5), kt,
                "Теория и Практика Нейронных Сетей", null);
        teacherRepository.save(kugaevskikh);
        teacherRepository.save(new TeacherEntity("Cергей", "Кугаевских", "",
                Category.ASSISTANT_PROFESSOR, Gender.MALE, false, 50000,
                false, LocalDate.of(2013, 12, 5), kt,
                "Теория поля", null));
        teacherRepository.save(new TeacherEntity("Cергей", "Кугаевских", "",
                Category.ASSISTANT_PROFESSOR, Gender.MALE, false, 50000,
                false, LocalDate.of(2013, 12, 5), kt,
                "Физика", null));

        LessonEntity tpns20201 = new LessonEntity("Теория и Практика Нейронных Сетей",
                kugaevskikh, group20201, 6, 3, LessonType.LECTURE, 72L);
        lessonRepository.save(tpns20201);
        LessonEntity tpns20202 = new LessonEntity("Теория и Практика Нейронных Сетей",
                kugaevskikh, group20202, 6, 3, LessonType.PRACTICE, 64L);
        lessonRepository.save(tpns20202);

        MarkEntity mark = new MarkEntity(tpns20201, sadriev, 5, LocalDate.of(2022, 6, 1));
        markRepository.save(mark);

        graduateWorkRepository.save(new GraduateWorkEntity(
                "Теория Поля", sadriev, kugaevskikh
        ));*/
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
        final LocalDate end = age == null ? null : LocalDate.now().minusYears(age);
        System.out.println(end);
        final LocalDate start = age == null ? null : end.minusYears(1);
        System.out.println(start);
        System.out.println(hasChildren);

        Set<StudentEntity> entities = retrieveAll(
                query.getGroups() == null ? null : Arrays.stream(query.getGroups())
                        .map(groupRepository::findById)
                        .toList(),
                query.getFaculties() == null ? null : Arrays.stream(query.getFaculties())
                        .map(facultyRepository::findById)
                        .toList(),
                (group, faculty) -> studentRepository.findStudent(
                        gender, year, start, end, hasChildren,
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
        if (dateStruct == null) return null;
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
    public Set<String> dissertations(@RequestBody DissertationsQuery query) {
        Set<TeacherEntity> entities = retrieveAll(Arrays.stream(query.getFaculties())
                        .map(facultyRepository::findById)
                        .toList(),
                Arrays.stream(query.getDepartments())
                        .map(departmentRepository::findById)
                        .toList(),
                (faculty, department) -> teacherRepository
                        .findTeachersByAffinity(department, faculty));
        if (entities == null) return new HashSet<>();
        return Stream.concat(entities.stream().map(TeacherEntity::getDoctoralDissertation),
                         entities.stream().map(TeacherEntity::getPhdDissertation))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    @PostMapping("/api/department_lessons")
    public Set<Department> departmentLessons(@RequestParam(required = false) Long groupId,
                                              @RequestParam(required = false) Integer course,
                                             @RequestParam(required = false) Long facultyId,
                                             @RequestParam(required = false) Integer term,
                                             @RequestBody(required = false) DepartmentLessonsQuery query) {
        GroupEntity groupEntity = null;
        if (groupId != null) {
            groupEntity = groupRepository.findById(groupId).orElse(null);
            if (groupEntity == null) {
                return new HashSet<>();
            }
        }
        FacultyEntity facultyEntity = null;
        if (facultyId != null) {
            facultyEntity = facultyRepository.findById(facultyId).orElse(null);
            if (facultyEntity == null) {
                return new HashSet<>();
            }
        }

        LocalDate start = null;
        LocalDate end = null;
        if (query != null && term != null) {
            start = convertDate(query.getStart());
            end = convertDate(query.getEnd());
        }

        if (start != null && end != null) {
            start = start.minusYears((term - 1) / 2)
                    .minusMonths(term % 2 == 0 ? 5 : 0);
            end = end.minusYears((term - 1) / 2)
                    .minusMonths(term % 2 == 0 ? 5 : 0);
        }

        return lessonRepository.findByGroup(groupEntity, course, facultyEntity, null, term,
                        start, end).stream()
                .map(LessonEntity::getTeacher)
                .map(TeacherEntity::getDepartment)
                .map(Department::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/api/lessons")
    public Set<Lesson> lessons(@RequestParam(required = false) Long groupId,
                               @RequestParam(required = false) Integer course) {
        GroupEntity groupEntity = null;
        if (groupId != null) {
            groupEntity = groupRepository.findById(groupId).orElse(null);
            if (groupEntity == null) {
                return new HashSet<>();
            }
        }
        return lessonRepository.findByGroup(groupEntity, course).stream()
                .map(Lesson::new)
                .collect(Collectors.toSet());
    }

    @PostMapping("/api/lessons_post")
    public Set<Lesson> lessonsPost(@RequestBody(required = false) LessonsQuery query) {
        return retrieveAll(query == null ? null : query.getGroupIds() == null ? null : Arrays.stream(query.getGroupIds()).map(groupRepository::findById).toList(), null,
                (group, none) -> {
                    return lessonRepository.findByGroup(group, null).stream()
                            .map(Lesson::new)
                            .collect(Collectors.toSet());
                });
    }

    @GetMapping("/api/teacher_lessons")
    public Set<Teacher> teacherLessons(@RequestParam(required = false) Long groupId,
                                          @RequestParam(required = false) Long lessonId,
                                             @RequestParam(required = false) Long facultyId,
                                             @RequestParam(required = false) Integer course) {
        GroupEntity groupEntity = null;
        if (groupId != null) {
            groupEntity = groupRepository.findById(groupId).orElse(null);
            if (groupEntity == null) {
                return new HashSet<>();
            }
        }
        FacultyEntity facultyEntity = null;
        if (facultyId != null) {
            facultyEntity = facultyRepository.findById(facultyId).orElse(null);
            if (facultyEntity == null) {
                return new HashSet<>();
            }
        }

        return lessonRepository.findByGroup(groupEntity, course, facultyEntity, lessonId,
                        null, null, null).stream()
                .map(LessonEntity::getTeacher)
                .map(Teacher::new)
                .collect(Collectors.toSet());
    }

    @PostMapping("/api/teacher_period")
    public Set<Teacher> teacherPeriod(@RequestParam(required = false) Long groupId,
                                      @RequestParam(required = false) Integer course,
                                      @RequestParam(required = false) Long facultyId,
                                      @RequestParam(required = false) Integer term,
                                      @RequestBody(required = false) DepartmentLessonsQuery query) {
        GroupEntity groupEntity = null;
        if (groupId != null) {
            groupEntity = groupRepository.findById(groupId).orElse(null);
            if (groupEntity == null) {
                return new HashSet<>();
            }
        }
        FacultyEntity facultyEntity = null;
        if (facultyId != null) {
            facultyEntity = facultyRepository.findById(facultyId).orElse(null);
            if (facultyEntity == null) {
                return new HashSet<>();
            }
        }

        LocalDate start = null;
        LocalDate end = null;
        if (query != null && term != null) {
            start = convertDate(query.getStart());
            end = convertDate(query.getEnd());
        }

        if (start != null && end != null) {
            start = start.minusYears((term - 1) / 2)
                    .minusMonths(term % 2 == 0 ? 5 : 0);
            end = end.minusYears((term - 1) / 2)
                    .minusMonths(term % 2 == 0 ? 5 : 0);
        }

        return lessonRepository.findByGroup(groupEntity, course, facultyEntity, null, term,
                        start, end).stream()
                .map(LessonEntity::getTeacher)
                .map(Teacher::new)
                .collect(Collectors.toSet());
    }

    @PostMapping("/api/students_with_marks")
    public Set<Student> studentsWithMarks(@RequestParam(required = false) Long lessonId,
                                          @RequestParam(required = false) Integer mark,
                                          @RequestBody(required = false) StudentsWithMarksQuery query) {
        LessonEntity lessonEntity = null;
        if (lessonId != null) {
            lessonEntity = lessonRepository.findById(lessonId).orElse(null);
            if (lessonEntity == null) {
                return new HashSet<>();
            }
        }
        final LessonEntity finalLessonEntity = lessonEntity;
        return new HashSet<>(retrieveAll(query == null ? null : Arrays.stream(query.getGroupIds()).map(groupRepository::findById).toList(), null,
                (group, none) -> {
                    return markRepository.findMarks(null, finalLessonEntity, mark, null)
                            .stream().map(MarkEntity::getStudent)
                            .map(Student::new)
                            .collect(Collectors.toSet());
                }));
    }

    @PostMapping("/api/students_of_course_with_marks")
    public Set<Student> studentsOfCourseWithMarks(@RequestParam(required = false) Integer course,
                                                @RequestParam(required = false) Long facultyId,
                                                @RequestParam(required = false) Integer term,
                                                 @RequestBody(required = false) StudentsOfCourseWithMarksQuery query) {
        FacultyEntity facultyEntity = null;
        if (facultyId != null) {
            facultyEntity = facultyRepository.findById(facultyId).orElse(null);
            if (facultyEntity == null) {
                return new HashSet<>();
            }
        }
        final FacultyEntity finalFacultyEntity = facultyEntity;
        return retrieveAll(query == null ? null : Arrays.stream(query.getGroupIds()).map(groupRepository::findById).toList(),
                query == null ? null : Arrays.stream(query.getMarks()).map(Optional::of).toList(),
                (group, mark) -> {
                    return markRepository.findMarks(course, finalFacultyEntity, group, term, mark)
                            .stream().map(MarkEntity::getStudent)
                            .map(Student::new)
                            .collect(Collectors.toSet());
                });
    }

    @PostMapping("/api/teachers_exams")
    public Set<Teacher> teachersExams(@RequestParam(required = false) Integer term,
            @RequestBody(required = false) TeachersExamsQuery query) {
        return retrieveAll(query == null ? null : Arrays.stream(query.getGroupIds()).map(groupRepository::findById).toList(),
                query == null ? null : Arrays.stream(query.getLessonIds()).map(lessonRepository::findById).toList(),
                (group, lesson) -> markRepository.findMarks(group, lesson, null, term)
                        .stream().map(MarkEntity::getLesson)
                        .map(LessonEntity::getTeacher)
                        .map(Teacher::new)
                        .collect(Collectors.toSet()));
    }

    @PostMapping("/api/students_exams")
    public Set<Student> studentsExams(@RequestParam(required = false) Long teacherId,
                                      @RequestParam(required = false) Integer mark,
                                      @RequestBody(required = false) StudentsExamsQuery query) {
        TeacherEntity teacherEntity = null;
        if (teacherId != null) {
            teacherEntity = teacherRepository.findById(teacherId).orElse(null);
            if (teacherEntity == null) {
                return new HashSet<>();
            }
        }
        final Set<MarkEntity> marks = new HashSet<>();
        for (Long groupId: query == null || query.getGroupIds().length == 0 ? new Long[] {null} : query.getGroupIds()) {
            for (Long lessonId: query == null || query.getLessonIds().length == 0 ? new Long[] {null} : query.getLessonIds()) {
                for (Integer term: query == null || query.getTerms().length == 0 ? new Integer[] {null} : query.getTerms()) {
                    final GroupEntity groupEntity = groupId == null ? null : groupRepository.findById(groupId).orElse(null);
                    final LessonEntity lessonEntity = lessonId == null ? null : lessonRepository.findById(lessonId).orElse(null);
                    marks.addAll(markRepository.findMarks(groupEntity, term, mark, lessonEntity, teacherEntity,
                            convertDate(query == null ? null : query.getStart()), convertDate(query == null ? null : query.getEnd())));
                }
            }
        }
        return marks.stream().map(MarkEntity::getStudent).map(Student::new).collect(Collectors.toSet());
    }

    @GetMapping("/api/students_graduate_works")
    public Set<StudentGraduateWork> studentsGraduateWorks(@RequestParam(required = false) Long departmentId,
                                                          @RequestParam(required = false) Long teacherId) {
        TeacherEntity teacherEntity = null;
        if (teacherId != null) {
            teacherEntity = teacherRepository.findById(teacherId).orElse(null);
            if (teacherEntity == null) {
                return new HashSet<>();
            }
        }
        DepartmentEntity departmentEntity = null;
        if (departmentId != null) {
            departmentEntity = departmentRepository.findById(departmentId).orElse(null);
            if (departmentEntity == null) {
                return new HashSet<>();
            }
        }

        return graduateWorkRepository.findGraduateWorks(departmentEntity, teacherEntity)
                .stream().map(w -> new StudentGraduateWork(w.getStudent(), w, w.getId()))
                .collect(Collectors.toSet());
    }

    @GetMapping("/api/teachers_graduate_works")
    public Set<Teacher> teachersGraduateWorks(@RequestParam(required = false) Long departmentId,
                                              @RequestParam(required = false) Long facultyId,
                                              @RequestParam(required = false) Category category) {
        DepartmentEntity departmentEntity = null;
        if (departmentId != null) {
            departmentEntity = departmentRepository.findById(departmentId).orElse(null);
            if (departmentEntity == null) {
                return new HashSet<>();
            }
        }
        FacultyEntity facultyEntity = null;
        if (facultyId != null) {
            facultyEntity = facultyRepository.findById(facultyId).orElse(null);
            if (facultyEntity == null) {
                return new HashSet<>();
            }
        }

        return graduateWorkRepository.findGraduateWorks(departmentEntity, facultyEntity, category)
                .stream().map(GraduateWorkEntity::getTeacher)
                .map(Teacher::new)
                .collect(Collectors.toSet());
    }

    @GetMapping("/api/teachers_load")
    public Load teachersLoad(@RequestParam(required = false) Long teacherId,
                                  @RequestParam(required = false) Long departmentId) {
        DepartmentEntity departmentEntity = null;
        if (departmentId != null) {
            departmentEntity = departmentRepository.findById(departmentId).orElse(null);
            if (departmentEntity == null) {
                return new Load(new Lesson[]{}, new Type[] {});
            }
        }
        TeacherEntity teacherEntity = null;
        if (teacherId != null) {
            teacherEntity = teacherRepository.findById(teacherId).orElse(null);
            if (teacherEntity == null) {
                return new Load(new Lesson[]{}, new Type[] {});
            }
        }
        return new Load(lessonRepository.findLessons(teacherEntity, departmentEntity).stream().map(Lesson::new).toList().toArray(new Lesson[] {}),
                        lessonRepository.findTypes(teacherEntity, departmentEntity).toArray(new Type[] {}));
    }

    @PostMapping("/api/student/add")
    @Transactional
    public Result addStudent(@RequestBody AddStudentBody student) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(student.getGroupId());
        var date = convertDate(student.getDateOfBirth());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        groupEntity.ifPresent(entity -> studentRepository.save(new StudentEntity(
                student.getFirstname(),
                student.getLastname(),
                student.getPatronymic(),
                date,
                student.getGender(),
                student.getHasChildren(),
                student.getScholarship(),
                entity
        )));
        return new Result(true, "Студент успешно добавлен");
    }

    @PostMapping("/api/student/delete")
    @Transactional
    public Result deleteStudent(@RequestParam Long id) {
        try {
            markRepository.deleteByStudentId(id);
            graduateWorkRepository.deleteByStudentId(id);
            studentRepository.deleteById(id);
        } catch (Exception e) {
            return new Result(false, "Нельзя удалить студента пока не удалены все ссылки на него");
        }
        return new Result(true, "Студент успешно удален");
    }

    @PostMapping("/api/student/update")
    @Transactional
    public Result updateStudent(@RequestParam Long id, @RequestBody AddStudentBody student) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(student.getGroupId());
        var date = convertDate(student.getDateOfBirth());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        groupEntity.ifPresent(entity -> {
            var newEntity = new StudentEntity(
                    student.getFirstname(),
                    student.getLastname(),
                    student.getPatronymic(),
                    date,
                    student.getGender(),
                    student.getHasChildren(),
                    student.getScholarship(),
                    entity
            );
            newEntity.setId(id);
            studentRepository.save(newEntity);
        });
        return new Result(true, "Студент успешно изменен");
    }

    @PostMapping("/api/teacher/add")
    @Transactional
    public Result addTeacher(@RequestBody AddTeacherBody teacher) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(teacher.getDepartmentId());
        LocalDate date = null;
        if (teacher.getPhdThesisDate() != null) {
            date = convertDate(teacher.getPhdThesisDate());
            if (date == null) {
                return new Result(false, "Поставьте правильную дату");
            }
        }
        final var localDate = date;
        departmentEntity.ifPresent(entity -> teacherRepository.save(new TeacherEntity(
                teacher.getFirstname(),
                teacher.getLastname(),
                teacher.getPatronymic(),
                teacher.getCategory(),
                teacher.getGender(),
                teacher.getHasChildren(),
                teacher.getSalary(),
                teacher.getGraduateStudent(),
                localDate,
                entity,
                teacher.getPhdDissertation(),
                teacher.getDoctoralDissertation()
        )));
        return new Result(true, "Преподаватель успешно добавлен");
    }

    @PostMapping("/api/teacher/delete")
    @Transactional
    public Result deleteTeacher(@RequestParam Long id) {
        try {
            markRepository.deleteByTeacherId(id);
            lessonRepository.deleteByTeacherId(id);
            graduateWorkRepository.deleteByTeacherId(id);
            teacherRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить преподавателя пока не удалены все ссылки на него");
        }
        return new Result(true, "Преподаватель успешно удален");
    }

    @PostMapping("/api/teacher/update")
    @Transactional
    public Result updateTeacher(@RequestParam Long id, @RequestBody AddTeacherBody teacher) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(teacher.getDepartmentId());
        LocalDate date = null;
        if (teacher.getPhdThesisDate() != null) {
            date = convertDate(teacher.getPhdThesisDate());
            if (date == null) {
                return new Result(false, "Поставьте правильную дату");
            }
        }
        final var localDate = date;
        departmentEntity.ifPresent(entity -> {
            var newEntity = new TeacherEntity(
                    teacher.getFirstname(),
                    teacher.getLastname(),
                    teacher.getPatronymic(),
                    teacher.getCategory(),
                    teacher.getGender(),
                    teacher.getHasChildren(),
                    teacher.getSalary(),
                    teacher.getGraduateStudent(),
                    localDate,
                    entity,
                    teacher.getPhdDissertation(),
                    teacher.getDoctoralDissertation()
            );
            newEntity.setId(id);
            teacherRepository.save(newEntity);
        });
        return new Result(true, "Преподаватель успешно изменен");
    }

    @PostMapping("/api/group/add")
    @Transactional
    public Result addGroup(@RequestBody AddGroupBody group) {
        Optional<FacultyEntity> facultyEntity = facultyRepository.findById(group.getFacultyId());
        var date = convertDate(group.getDate());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        try {
            facultyEntity.ifPresent(entity -> groupRepository.save(new GroupEntity(
                    group.getName(),
                    date,
                    entity
            )));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Группа не была добавлена");
        }

        return new Result(true, "Группа успешно добавлена");
    }

    @PostMapping("/api/group/delete")
    @Transactional
    public Result deleteGroup(@RequestParam Long id) {
        try {
            markRepository.deleteByGroupId(id);
            graduateWorkRepository.deleteByGroupId(id);
            studentRepository.deleteByGroupId(id);
            lessonRepository.deleteByGroupId(id);
            groupRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить группу пока не удалены все ссылки на нее");
        }
        return new Result(true, "Группа успешно удалена");
    }

    @PostMapping("/api/group/update")
    public Result updateGroup(@RequestParam Long id, @RequestBody AddGroupBody group) {
        Optional<FacultyEntity> facultyEntity = facultyRepository.findById(group.getFacultyId());
        var date = convertDate(group.getDate());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        try {
            facultyEntity.ifPresent(entity -> {
                var newEntity = new GroupEntity(
                        group.getName(),
                        date,
                        entity
                );
                newEntity.setId(id);
                groupRepository.save(newEntity);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Группа не была изменена");
        }

        return new Result(true, "Группа успешно изменена");
    }

    @PostMapping("/api/faculty/add")
    @Transactional
    public Result addFaculty(@RequestBody AddFacultyBody faculty) {
        try {
            facultyRepository.save(new FacultyEntity(faculty.getName()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Факультет не был добавлен");
        }

        return new Result(true, "Факультет успешно добавлен");
    }

    @PostMapping("/api/faculty/delete")
    @Transactional
    public Result deleteFaculty(@RequestParam Long id) {
        try {
            markRepository.deleteByFacultyId(id);
            graduateWorkRepository.deleteByFacultyId(id);
            studentRepository.deleteByFacultyId(id);
            lessonRepository.deleteByFacultyId(id);
            groupRepository.deleteByFacultyId(id);

            teacherRepository.deleteByFacultyId(id);
            departmentRepository.deleteByFacultyId(id);
            facultyRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить фвкультет пока не удалены все ссылки на нее");
        }
        return new Result(true, "Факультет успешно удален");
    }

    @PostMapping("/api/faculty/update")
    public Result updateFaculty(@RequestParam Long id, @RequestBody AddFacultyBody faculty) {
        try {
            var entity = new FacultyEntity(faculty.getName());
            entity.setId(id);
            facultyRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Факультет не был изменен");
        }

        return new Result(true, "Факультет успешно изменен");
    }

    @PostMapping("/api/department/add")
    @Transactional
    public Result addDepartment(@RequestBody AddDepartmentBody department) {
        Optional<FacultyEntity> facultyEntity = facultyRepository.findById(department.getFacultyId());
        try {
            facultyEntity.ifPresent(entity -> departmentRepository.save(new DepartmentEntity(
                    department.getName(),
                    entity
            )));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Кафедра не была добавлена");
        }

        return new Result(true, "Кафедра успешно добавлена");
    }

    @PostMapping("/api/department/delete")
    @Transactional
    public Result deleteDepartment(@RequestParam Long id) {
        try {
            markRepository.deleteByDepartmentId(id);
            graduateWorkRepository.deleteByDepartmentId(id);
            lessonRepository.deleteByDepartmentId(id);
            teacherRepository.deleteByDepartmentId(id);
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить кафедру пока не удалены все ссылки на нее");
        }
        return new Result(true, "Кафедра успешно удалена");
    }

    @PostMapping("/api/department/update")
    public Result updateDepartment(@RequestParam Long id, @RequestBody AddDepartmentBody department) {
        Optional<FacultyEntity> facultyEntity = facultyRepository.findById(department.getFacultyId());
        try {
            facultyEntity.ifPresent(entity -> {
                var departmentEntity = new DepartmentEntity(
                        department.getName(),
                        entity
                );
                departmentEntity.setId(id);
                departmentRepository.save(departmentEntity);
            });
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Кафедра не была изменена");
        }

        return new Result(true, "Кафедра успешно изменена");
    }

    @PostMapping("/api/work/add")
    @Transactional
    public Result addWork(@RequestBody AddWorkBody graduateWork) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(graduateWork.getTeacherId());
        Optional<StudentEntity> studentEntity = studentRepository.findById(graduateWork.getStudentId());
        try {
            teacherEntity.ifPresent(teacher -> studentEntity.ifPresent(student -> {
                graduateWorkRepository.save(new GraduateWorkEntity(
                        graduateWork.getTheme(),
                        student,
                        teacher
                ));
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Работа не была добавлена");
        }

        return new Result(true, "Работа успешно добавлена");
    }

    @PostMapping("/api/work/delete")
    @Transactional
    public Result deleteWork(@RequestParam Long id) {
        try {
            graduateWorkRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить работу пока не удалены все ссылки на нее");
        }
        return new Result(true, "Работа успешно удалена");
    }

    @PostMapping("/api/work/update")
    public Result updateWork(@RequestParam Long id, @RequestBody AddWorkBody graduateWork) {
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(graduateWork.getTeacherId());
        Optional<StudentEntity> studentEntity = studentRepository.findById(graduateWork.getStudentId());
        try {
            teacherEntity.ifPresent(teacher -> studentEntity.ifPresent(student -> {
                var entity =  new GraduateWorkEntity(
                        graduateWork.getTheme(),
                        student,
                        teacher
                );
                entity.setId(id);
                graduateWorkRepository.save(entity);
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Работа не была изменена");
        }

        return new Result(true, "Работа успешно изменена");
    }

    @PostMapping("/api/mark/add")
    @Transactional
    public Result addMark(@RequestBody AddMarkBody mark) {
        Optional<LessonEntity> lessonEntity = lessonRepository.findById(mark.getLessonId());
        Optional<StudentEntity> studentEntity = studentRepository.findById(mark.getStudentId());
        var date = convertDate(mark.getDate());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        try {
            lessonEntity.ifPresent(lesson -> studentEntity.ifPresent(student -> {
                markRepository.save(new MarkEntity(
                        lesson,
                        student,
                        mark.getMark(),
                        date
                ));
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Оценка не была добавлена");
        }

        return new Result(true, "Оценка успешно добавлена");
    }

    @PostMapping("/api/mark/delete")
    @Transactional
    public Result deleteMark(@RequestParam Long id) {
        try {
            markRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить оценку пока не удалены все ссылки на нее");
        }
        return new Result(true, "Оценка успешно удалена");
    }

    @PostMapping("/api/mark/update")
    public Result updateMark(@RequestParam Long id, @RequestBody AddMarkBody mark) {
        Optional<LessonEntity> lessonEntity = lessonRepository.findById(mark.getLessonId());
        Optional<StudentEntity> studentEntity = studentRepository.findById(mark.getStudentId());
        var date = convertDate(mark.getDate());
        if (date == null) {
            return new Result(false, "Поставьте правильную дату");
        }
        try {
            lessonEntity.ifPresent(lesson -> studentEntity.ifPresent(student -> {
                var entity = new MarkEntity(
                        lesson,
                        student,
                        mark.getMark(),
                        date
                );
                entity.setId(id);
                markRepository.save(entity);
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Оценка не была изменена");
        }

        return new Result(true, "Оценка успешно изменена");
    }

    @GetMapping("/api/mark/all")
    public ArrayList<MarkString> getMarks() {
        ArrayList<MarkString> marks = new ArrayList<>();
        markRepository.findAll().forEach(mark -> {
            var date = new DateStruct(mark.getDate());
            marks.add(new MarkString(
                    mark.getId(),
                    mark.getMark(),
                    mark.getLesson().getName(),
                    (mark.getStudent().getFirstname() + " " + mark.getStudent().getLastname() + " " + mark.getStudent().getPatronymic()),
                    mark.getLesson().getId(),
                    mark.getStudent().getId(),
                    date
            ));
        });
        return marks;
    }

    @PostMapping("/api/lesson/add")
    @Transactional
    public Result addLesson(@RequestBody AddLessonBody lesson) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(lesson.getGroupId());
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(lesson.getTeacherId());
        try {
            groupEntity.ifPresent(group -> teacherEntity.ifPresent(teacher -> {
                lessonRepository.save(new LessonEntity(
                        lesson.getName(),
                        teacher,
                        group,
                        lesson.getTerm(),
                        lesson.getCourse(),
                        lesson.getType(),
                        lesson.getHours()
                ));
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Предмет не был добавлен");
        }

        return new Result(true, "Предмет успешно добавлен");
    }

    @PostMapping("/api/lesson/delete")
    @Transactional
    public Result deleteLesson(@RequestParam Long id) {
        try {
            markRepository.deleteByLessonId(id);
            lessonRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Нельзя удалить предмет пока не удалены все ссылки на нее");
        }
        return new Result(true, "Предмет успешно удален");
    }

    @PostMapping("/api/lesson/update")
    public Result updateLesson(@RequestParam Long id, @RequestBody AddLessonBody lesson) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(lesson.getGroupId());
        Optional<TeacherEntity> teacherEntity = teacherRepository.findById(lesson.getTeacherId());
        try {
            groupEntity.ifPresent(group -> teacherEntity.ifPresent(teacher -> {
                var entity = new LessonEntity(
                        lesson.getName(),
                        teacher,
                        group,
                        lesson.getTerm(),
                        lesson.getCourse(),
                        lesson.getType(),
                        lesson.getHours()
                );
                entity.setId(id);
                lessonRepository.save(entity);
            }));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Предмет не был изменен");
        }

        return new Result(true, "Предмет успешно изменен");
    }
}
