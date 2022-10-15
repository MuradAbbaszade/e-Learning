package com.company.common;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class AbstractEntity {
    @Column(name="id")
    private Long id;
}
