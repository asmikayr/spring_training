package com.cydeo.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre extends BaseEntity {
    private String name;
}
