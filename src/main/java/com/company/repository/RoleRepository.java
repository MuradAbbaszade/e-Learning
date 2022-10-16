package com.company.repository;

import com.company.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query(value = "select * from role where name=:name",nativeQuery = true)
    Optional<RoleEntity> findByName(@Param("name") String name);
}
