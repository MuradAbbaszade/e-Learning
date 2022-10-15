package com.company.repository;

import com.company.entity.StudentEntity;
import com.company.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity,Long> {
    @Query(value = "select * from teacher where email=:email",nativeQuery = true)
    Optional<TeacherEntity> findByEmail(@Param("email") String email);
}
