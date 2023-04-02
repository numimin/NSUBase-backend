package com.github.numi.repositories;

import com.github.numi.entities.GroupEntity;
import com.github.numi.entities.StudentEntity;
import com.github.numi.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    @Query("SELECT s FROM StudentEntity s WHERE (:gender IS NULL OR :gender = s.gender) AND (:year IS NULL OR :year = YEAR(s.dateOfBirth)) AND (:age IS NULL OR :age = DATEDIFF(YEAR, s.dateOfBirth, CURRENT_DATE())) AND (:hasChildren IS NULL OR :hasChildren = s.hasChildren) AND (:minScholarship IS NULL OR :minScholarship <= s.scholarship) AND (:maxScholarship IS NULL OR s.scholarship <= :maxScholarship) AND (:group IS NULL OR s.group = :group)")
    Set<StudentEntity> findStudent(@Param("gender") Gender gender,
                                   @Param("year")Integer year,
                                   @Param("age")Integer age,
                                   @Param("hasChildren")Boolean hasChildren,
                                   @Param("minScholarship")Integer minScholarship,
                                   @Param("maxScholarship")Integer maxScholarship,
                                   @Param("group")GroupEntity group);
}
