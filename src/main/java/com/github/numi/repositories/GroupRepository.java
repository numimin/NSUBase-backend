package com.github.numi.repositories;

import com.github.numi.entities.FacultyEntity;
import com.github.numi.entities.GroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
    @Query("SELECT g FROM GroupEntity g WHERE g.faculty = :faculty")
    List<GroupEntity> findGroups(@Param("faculty") FacultyEntity faculty);
    @Query("SELECT g FROM GroupEntity g")
    List<GroupEntity> findGroups();
}
