package com.demo.pms.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
@Data
public class PersonEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "created_on", updatable = false, nullable = false)
    @CreationTimestamp
    private Date createdOn;

    @Column(name = "modified_on", updatable = false, nullable = false)
    @UpdateTimestamp
    private Date modifiedOn;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "modified_by", updatable = false)
    private String modifiedBy;

    @Column(name = "first_name", updatable = true, nullable = false)
    private String firstName;

    @Column(name = "last_name", updatable = true, nullable = false)
    private String lastName;

    @Column(name = "gender", updatable = true, nullable = false)
    private String gender;

    @Column(name = "age", updatable = true, nullable = false)
    private int age;

    @Column(name = "favourite_color", updatable = true, nullable = true)
    private String favouriteColor;

    @Column(name = "hobbies", updatable = true, nullable = false)
    private byte[] hobbies;
}
