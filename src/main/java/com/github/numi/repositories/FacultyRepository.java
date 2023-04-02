package com.github.numi.repositories;

import com.github.numi.entities.FacultyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacultyRepository extends CrudRepository<FacultyEntity, Long> {
    @Query("SELECT f FROM FacultyEntity f")
    List<FacultyEntity> findFaculties();
}
