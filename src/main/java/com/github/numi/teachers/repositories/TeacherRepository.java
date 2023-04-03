package com.github.numi.teachers.repositories;

import com.github.numi.students.entities.FacultyEntity;
import com.github.numi.students.enums.Gender;
import com.github.numi.teachers.entities.DepartmentEntity;
import com.github.numi.teachers.entities.TeacherEntity;
import com.github.numi.teachers.enums.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Set;

public interface TeacherRepository extends CrudRepository<TeacherEntity, Long> {
    @Query("SELECT t FROM TeacherEntity t WHERE" +
           "(:category IS NULL OR :category = t.category) AND" +
           "(:gender IS NULL OR :gender = t.gender) AND" +
           "(:hasChildren IS NULL OR :hasChildren = t.hasChildren) AND" +
           "(:minSalary IS NULL OR :minSalary <= t.salary) AND" +
           "(:maxSalary IS NULL OR :maxSalary >= t.salary) AND" +
           "(:graduateStudent IS NULL OR :graduateStudent = t.graduateStudent) AND" +
           "(:phdThesisStartDate IS NULL OR :phdThesisStartDate <= t.phdThesisDate) AND" +
           "(:phdThesisEndDate IS NULL OR :phdThesisEndDate >= t.phdThesisDate) AND" +
           "(:department IS NULL OR :department = t.department) AND" +
           "(:faculty IS NULL OR :faculty = t.department.faculty)"
    )
    Set<TeacherEntity> findTeachers(@Param("category") Category category,
                                    @Param("gender") Gender gender,
                                    @Param("hasChildren") Boolean hasChildren,
                                    @Param("minSalary") Integer minSalary,
                                    @Param("maxSalary") Integer maxSalary,
                                    @Param("graduateStudent") Boolean graduateStudent,
                                    @Param("phdThesisStartDate") LocalDate phdThesisStartDate,
                                    @Param("phdThesisEndDate") LocalDate phdThesisEndDate,
                                    @Param("department") DepartmentEntity department,
                                    @Param("faculty")FacultyEntity faculty);
    @Query("SELECT t FROM TeacherEntity t WHERE" +
            "(:department IS NULL OR :department = t.department) AND" +
            "(:faculty IS NULL OR :faculty = t.department.faculty)")
    Set<TeacherEntity> findTeachersByAffinity(@Param("department") DepartmentEntity department,
                                              @Param("faculty")FacultyEntity faculty);
}
