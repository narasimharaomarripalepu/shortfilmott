package com.shortfilmott.shortfilmott.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(
    name="tbl_ratings"
)
public class ratings {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long ratingId;
    // Long userId;
    // Long movieid;
    

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name="user_Id",
        referencedColumnName = "user_id"
    )
    private users user;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name="shortfilm_Id",
        referencedColumnName = "shortfilm_id"
    )
    private shortfilms shortfilm;

    Double rating;

}
