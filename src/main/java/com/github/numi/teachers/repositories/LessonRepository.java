package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.LessonEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.json.Load;
import com.github.numi.teachers.json.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

public interface LessonRepository extends CrudRepository<LessonEntity, Long> {
    @Query("SELECT l FROM LessonEntity l WHERE (:group IS NULL OR l.group = :group) AND " +
            "(:course IS NULL OR :course = l.course) AND " +
            "(:faculty IS NULL OR :faculty = l.group.faculty) AND " +
            "(:lessonId IS NULL OR :lessonId = l.id) AND " +
            "(:term IS NULL OR :term = l.term) AND " +
            "(:start IS NULL OR :end IS NULL OR NOT (:end < :start OR l.group.end_ < :start OR :end < l.group.date))"
    )
    Set<LessonEntity> findByGroup(@Param("group") GroupEntity group,
                                  @Param("course") Integer course,
                                  @Param("faculty")FacultyEntity faculty,
                                  @Param("lessonId")Long lessonId,
                                   @Param("term") Integer term,
                                   @Param("start")LocalDate start,
                                   @Param("end") LocalDate end);

    @Query("SELECT l FROM LessonEntity l WHERE (:group IS NULL OR l.group = :group) AND" +
            "(:course IS NULL OR :course = l.course)"
    )
    Set<LessonEntity> findByGroup(@Param("group") GroupEntity group,
                                  @Param("course") Integer course);

    @Query("SELECT l FROM LessonEntity l WHERE " +
            "(:teacher IS NULL OR :teacher = l.teacher) AND " +
            "(:department IS NULL OR :department = l.teacher.department)"
    )
    Set<LessonEntity> findLessons(@Param("teacher") TeacherEntity teacher,
                       @Param("department") DepartmentEntity department);
    @Query("SELECT NEW com.github.numi.teachers.json.Type(l.type, SUM(l.hours)) FROM LessonEntity l WHERE " +
            "(:teacher IS NULL OR :teacher = l.teacher) AND " +
            "(:department IS NULL OR :department = l.teacher.department) " +
            "GROUP BY l.type"
    )

    Set<Type> findTypes(@Param("teacher") TeacherEntity teacher,
                        @Param("department") DepartmentEntity department);

    @Modifying
    @Query("DELETE FROM LessonEntity l WHERE :id = l.teacher.id")
    void deleteByTeacherId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM LessonEntity l WHERE :id = l.group.id")
    void deleteByGroupId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM LessonEntity l WHERE :id IN (SELECT l.group.faculty.id FROM LessonEntity l WHERE :id = l.group.faculty.id)")
    void deleteByFacultyId(@Param("id") Long id);
}
