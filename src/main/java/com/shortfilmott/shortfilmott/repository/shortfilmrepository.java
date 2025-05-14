package com.shortfilmott.shortfilmott.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shortfilmott.shortfilmott.entity.shortfilms;
import com.shortfilmott.shortfilmott.entity.users;

@Repository
public interface shortfilmrepository extends JpaRepository<shortfilms, Long>{

    List<shortfilms> findAllByGenere(String genere);

    List<shortfilms> findAllByUser(users user);

}