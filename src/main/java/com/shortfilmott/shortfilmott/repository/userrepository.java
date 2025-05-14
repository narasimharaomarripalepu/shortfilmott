package com.shortfilmott.shortfilmott.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shortfilmott.shortfilmott.entity.users;

@Repository
public interface userrepository extends JpaRepository<users, Long> {


    public users findByUserEmail(String user_email);

}
