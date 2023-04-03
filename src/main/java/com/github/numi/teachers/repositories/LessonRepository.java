package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.teachers.entities.LessonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Set;

public interface LessonRepository extends CrudRepository<LessonEntity, Long> {
    @Query("SELECT l FROM LessonEntity l WHERE (:group IS NULL OR l.group = :group) AND " +
            "(:course IS NULL OR :course = l.course) AND " +
            "(:faculty IS NULL OR :faculty = l.group.faculty) AND " +
            "(:lessonId IS NULL OR :lessonId = l.id) AND " +
            "(:term IS NULL OR :term = l.term) AND " +
            "(:start IS NULL OR :end IS NULL OR l.group.date BETWEEN :start AND :end)"
    )
    Set<LessonEntity> findByGroup(@Param("group") GroupEntity group,
                                  @Param("course") Integer course,
                                  @Param("faculty")FacultyEntity faculty,
                                  @Param("lessonId")Long lessonId,
                                   @Param("term") Integer term,
                                   @Param("start")LocalDate start,
                                   @Param("end") LocalDate end);

    @Query("SELECT l FROM LessonEntity l WHERE (:group IS NULL OR l.group = :group)")
    Set<LessonEntity> findByGroup(@Param("group") GroupEntity group);
}
