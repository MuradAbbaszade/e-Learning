package com.company.entity;

import com.company.common.AbstractEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="field",schema = "public")
public class FieldEntity extends AbstractEntity {
    @Column(name="name")
    private String name;
}
