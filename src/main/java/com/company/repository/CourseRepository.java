package com.company.repository;

import com.company.entity.CourseEntity;
import com.company.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    @Query(value = "select * from course where course.name like %:q%",nativeQuery = true)
    Optional<List<CourseEntity>> findByQuery(@Param("q") String q);
}
