package com.github.numi.students.repositories;

import com.github.numi.students.entities.GroupEntity;
import com.github.numi.students.entities.MarkEntity;
import com.github.numi.teachers.entities.LessonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MarkRepository extends CrudRepository<MarkEntity, Long> {
    @Query("SELECT m FROM MarkEntity m WHERE " +
            "(:group IS NULL OR :group = m.student.group) AND " +
            "(:lesson IS NULL OR :lesson = m.lesson) AND " +
            "(:mark IS NULL OR :mark = m.mark)"
    )
    Set<MarkEntity> findMarks(@Param("group")GroupEntity group,
                              @Param("lesson")LessonEntity lesson,
                              @Param("mark") Integer mark);
}
