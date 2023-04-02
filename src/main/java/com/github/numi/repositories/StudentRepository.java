package com.github.numi.repositories;

import com.github.numi.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
    StudentEntity findByFirstname(String firstname);
}
