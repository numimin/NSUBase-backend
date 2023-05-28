package com.github.numi.students.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.students.entities.MarkEntity;
import com.github.numi.teachers.entities.LessonEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Set;

public interface MarkRepository extends CrudRepository<MarkEntity, Long> {
    @Query("SELECT m FROM MarkEntity m WHERE " +
            "(:group IS NULL OR :group = m.student.group) AND " +
            "(:lesson IS NULL OR :lesson = m.lesson) AND " +
            "(:mark IS NULL OR :mark = m.mark) AND " +
            "(:term IS NULL OR :term = m.lesson.term)"
    )
    Set<MarkEntity> findMarks(@Param("group")GroupEntity group,
                              @Param("lesson")LessonEntity lesson,
                              @Param("mark") Integer mark,
                              @Param("term") Integer term);
    @Query("SELECT m FROM MarkEntity m WHERE " +
            "(:course IS NULL OR :course = m.lesson.course) AND" +
            "(:faculty IS NULL OR :faculty = m.student.group.faculty) AND" +
            "(:group IS NULL OR :group = m.student.group) AND" +
            "(:term IS NULL OR :term = m.lesson.term) AND" +
            "(:mark IS NULL OR :mark = m.mark)"
    )
    Set<MarkEntity> findMarks(@Param("course") Integer course,
                              @Param("faculty") FacultyEntity faculty,
                              @Param("group")GroupEntity group,
                              @Param("term") Integer term,
                              @Param("mark") Integer mark);

    @Query("SELECT m FROM MarkEntity m WHERE " +
            "(:group IS NULL OR :group = m.student.group) AND" +
            "(:term IS NULL OR :term = m.lesson.term) AND" +
            "(:mark IS NULL OR :mark = m.mark) AND " +
            "(:lesson IS NULL OR :lesson = m.lesson) AND " +
            "(:teacher IS NULL OR :teacher = m.lesson.teacher) AND " +
            "(:start IS NULL OR :end IS NULL OR m.date BETWEEN :start AND :end)"
    )
    Set<MarkEntity> findMarks(@Param("group")GroupEntity group,
                              @Param("term") Integer term,
                              @Param("mark") Integer mark,
                              @Param("lesson") LessonEntity lesson,
                              @Param("teacher") TeacherEntity teacher,
                              @Param("start") LocalDate start,
                              @Param("end") LocalDate end);

    @Modifying
    @Query("DELETE FROM MarkEntity m WHERE :id = m.student.id")
    void deleteByStudentId(@Param("id") Long studentId);

    @Modifying
    @Query("DELETE FROM MarkEntity m WHERE :id IN (SELECT m.lesson.teacher.id FROM MarkEntity m WHERE m.lesson.teacher.id = :id)")
    void deleteByTeacherId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM MarkEntity m WHERE :id IN (SELECT m.student.group.id FROM MarkEntity m WHERE m.student.group.id = :id)")
    void deleteByGroupId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM MarkEntity m WHERE :id IN (SELECT m.student.group.faculty.id FROM MarkEntity m WHERE m.student.group.faculty.id = :id)")
    void deleteByFacultyId(@Param("id") Long id);
}
