package com.github.numi.repositories;

import com.github.numi.entities.GroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<GroupEntity, Long> {
    @Query("SELECT g FROM GroupEntity g")
    List<GroupEntity> findGroups();

    List<GroupEntity> findByName(String name);
}
