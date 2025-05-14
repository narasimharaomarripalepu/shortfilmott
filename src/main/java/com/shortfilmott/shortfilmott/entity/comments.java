package com.shortfilmott.shortfilmott.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class comments {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "user_id"
    )
    private users user;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "shortfilm_id",
        referencedColumnName = "shortfilm_id"
    )
    private shortfilms shortfilm;

    private String comment;

}
