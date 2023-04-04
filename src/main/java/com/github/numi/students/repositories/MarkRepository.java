package com.github.numi.students.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.students.entities.MarkEntity;
import com.github.numi.teachers.entities.LessonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Set;

public interface MarkRepository extends CrudRepository<MarkEntity, Long> {
    @Query("SELECT m FROM MarkEntity m WHERE " +
            "(:group IS NULL OR :group = m.student.group) AND " +
            "(:lesson IS NULL OR :lesson = m.lesson) AND " +
            "(:mark IS NULL OR :mark = m.mark)"
    )
    Set<MarkEntity> findMarks(@Param("group")GroupEntity group,
                              @Param("lesson")LessonEntity lesson,
                              @Param("mark") Integer mark);
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
}
