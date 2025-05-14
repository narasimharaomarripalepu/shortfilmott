package com.shortfilmott.shortfilmott.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shortfilmott.shortfilmott.entity.comments;
import com.shortfilmott.shortfilmott.entity.shortfilms;


@Repository
public interface commentrepository extends JpaRepository<comments,Long> {

    List<comments> findAllByShortfilm(shortfilms shortfilm);

}
