package com.github.numi.teachers.repositories;

import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.GraduateWorkEntity;
import com.github.numi.teachers.entities.TeacherEntity;
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
}
