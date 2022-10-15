package com.company.repository;

import com.company.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "select * from student where email=:email",nativeQuery = true)
    Optional<StudentEntity> findByEmail(@Param("email") String email);
}
