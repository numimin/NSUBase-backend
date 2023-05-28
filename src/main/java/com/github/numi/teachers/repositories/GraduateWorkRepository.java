package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.GraduateWorkEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;
import com.github.numi.teachers.json.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface GraduateWorkRepository extends CrudRepository<GraduateWorkEntity, Long> {
    @Query("SELECT w FROM GraduateWorkEntity w WHERE " +
        "(:department IS NULL OR :department = w.teacher.department) AND" +
        "(:teacher IS NULL OR :teacher = w.teacher)"
    )
    Set<GraduateWorkEntity> findGraduateWorks(@Param("department")DepartmentEntity department,
                                              @Param("teacher")TeacherEntity teacher);

    @Query("SELECT w FROM GraduateWorkEntity w WHERE " +
            "(:department IS NULL OR :department = w.teacher.department) AND " +
            "(:faculty IS NULL OR :faculty = w.teacher.department.faculty) AND " +
            "(:category IS NULL OR :category = w.teacher.category)"
    )
    Set<GraduateWorkEntity> findGraduateWorks(@Param("department") DepartmentEntity department,
                                              @Param("faculty") FacultyEntity faculty,
                                              @Param("category") Category category);

    @Modifying
    @Query("DELETE FROM GraduateWorkEntity w WHERE :id = w.student.id")
    void deleteByStudentId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM GraduateWorkEntity w WHERE :id = w.teacher.id")
    void deleteByTeacherId(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM GraduateWorkEntity w WHERE :id IN (SELECT w.student.group.id FROM GraduateWorkEntity w WHERE w.student.group.id = :id)")
    void deleteByGroupId(@Param("id") Long id);
}
