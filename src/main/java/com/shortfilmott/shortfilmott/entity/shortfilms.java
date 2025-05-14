package com.shortfilmott.shortfilmott.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(
    name="tbl_shortfilms",
    uniqueConstraints=@UniqueConstraint(
        name="link_unique",
        columnNames="link"
    )
)
public class shortfilms implements Comparable<shortfilms> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shortfilm_id;
    private String shortfilm_name;
    private String description;
    private String link;
    // private Long recommended_by_id;
    private double rating;
    // @Lob
    // private byte[] image;

    private String imagelink;

    private String genere;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name="user_Id",
        referencedColumnName = "user_id"
    )
    private users user;

    @Override
    public int compareTo(shortfilms other) {
        // return Integer.compare((int)this.rating, (int)other.rating);
        return (int) Double.compare(this.rating,other.rating);
    }



}
