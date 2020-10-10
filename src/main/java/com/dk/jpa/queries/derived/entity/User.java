package com.dk.jpa.queries.derived.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private int age;
    private Date birthDate;
    private boolean active;

    public User(String name, String email, int age, Date birthDate, boolean active) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthDate = birthDate;
        this.active = active;
    }
}
