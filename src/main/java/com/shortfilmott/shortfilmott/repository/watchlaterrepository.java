package com.shortfilmott.shortfilmott.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import com.shortfilmott.shortfilmott.entity.users;
import com.shortfilmott.shortfilmott.entity.watchlater;

import jakarta.transaction.Transactional;

public interface watchlaterrepository extends JpaRepository<watchlater, Long> {

    

    public List<watchlater> findAllByUser(users user);

    @Modifying
    @Transactional
    @NativeQuery(value="delete from tbl_watch_later where user_id =?1 AND shortfilm_id=?2")
    public void deletewacthlater(@Param("user_id") Long user_id, @Param("shortfilm_id") Long shortfilm_id);

}
