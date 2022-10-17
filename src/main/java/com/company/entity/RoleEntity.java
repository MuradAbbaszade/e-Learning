package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="role",schema = "public")
public class RoleEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @ManyToMany(mappedBy = "roleEntityList",fetch = FetchType.EAGER)
    private List<UserEntity> userEntityList;
    public RoleEntity(String name){
        this.name=name;
    }
}
