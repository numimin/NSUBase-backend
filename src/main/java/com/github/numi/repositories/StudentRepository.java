package com.github.numi.repositories;

import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    @Query("SELECT s FROM StudentEntity s WHERE :gender = s.gender AND :year = YEAR(s.dateOfBirth) AND :age = DATEDIFF(YEAR, s.dateOfBirth, CURRENT_DATE()) AND :hasChildren = s.hasChildren AND :minScholarship <= s.scholarship AND s.scholarship <= :maxScholarship")
    List<StudentEntity> findStudent(@Param("gender") Gender gender,
                                    @Param("year")Integer year,
                                    @Param("age")Integer age,
                                    @Param("hasChildren")Boolean hasChildren,
                                    @Param("minScholarship")Integer minScholarship,
                                    @Param("maxScholarship")Integer maxScholarship);
}
