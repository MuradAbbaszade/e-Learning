package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(name="user",schema = "public")
public class UserEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @ManyToMany(mappedBy = "studentUserEntityList",fetch = FetchType.EAGER)
    private List<CourseEntity> purchasedCourseEntityList;
    @OneToMany(mappedBy = "teacherUserEntity")
    private List<CourseEntity> createdCourseEntityList;
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roleEntityList;
}
