package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.entities.GroupEntity;
import com.github.numi.teachers.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Long> {
    @Query("SELECT d FROM DepartmentEntity d WHERE d.faculty = :faculty")
    List<DepartmentEntity> findDepartments(@Param("faculty") FacultyEntity faculty);
    @Query("SELECT d FROM DepartmentEntity d")
    List<DepartmentEntity> findDepartments();
}
