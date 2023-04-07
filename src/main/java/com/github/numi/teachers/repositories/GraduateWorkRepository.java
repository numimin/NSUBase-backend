package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.GraduateWorkEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;
import com.github.numi.teachers.json.Teacher;
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
}