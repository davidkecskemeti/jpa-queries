package com.dk.jpa.queries.custom.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int priority;
    private boolean featured;
    private Date created;

    public Note(String title, int priority, boolean featured, Date created) {
        this.title = title;
        this.priority = priority;
        this.featured = featured;
        this.created = created;
    }

}
