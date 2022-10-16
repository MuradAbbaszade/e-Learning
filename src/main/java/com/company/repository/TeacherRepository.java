package com.company.repository;

import com.company.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleR extends JpaRepository<RoleEntity,Long> {
    @Query(value = "select * from teacher where email=:email",nativeQuery = true)
    Optional<RoleEntity> findByEmail(@Param("email") String email);
}
