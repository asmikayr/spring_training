package com.cydeo.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Location extends BaseEntity{

    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;

    private String postalCode;
    private String country;
    private String state;
    private String city;
    private String address;

}
