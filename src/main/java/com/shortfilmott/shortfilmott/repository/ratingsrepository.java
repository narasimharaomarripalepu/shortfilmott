package com.shortfilmott.shortfilmott.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shortfilmott.shortfilmott.entity.ratings;
import com.shortfilmott.shortfilmott.entity.shortfilms;

@Repository
public interface ratingsrepository extends JpaRepository<ratings, Long> {

    public List<ratings> findByShortfilm(shortfilms shortfilm);

}
