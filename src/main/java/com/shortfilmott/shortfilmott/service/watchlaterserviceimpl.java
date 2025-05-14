package com.shortfilmott.shortfilmott.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shortfilmott.shortfilmott.entity.watchlater;
import com.shortfilmott.shortfilmott.repository.shortfilmrepository;
import com.shortfilmott.shortfilmott.repository.userrepository;
import com.shortfilmott.shortfilmott.repository.watchlaterrepository;

@Service
public class watchlaterserviceimpl implements watchlaterservice {

    @Autowired
    private watchlaterrepository watchlaterdb;

    @Autowired
    private userrepository userdb;

    @Autowired
    private shortfilmrepository shortfilmdb;


    @Override
    public watchlater saveMovie(Long user_id, Long s_id) {
        watchlater wlater=new watchlater();
        wlater.setUser(userdb.findById(user_id).get());
        wlater.setShortfilm(shortfilmdb.findById(s_id).get());
        return watchlaterdb.save(wlater);
    }


    @Override
    public List<watchlater> watchlaterfilms(Long user_id) {
       return watchlaterdb.findAllByUser(userdb.findById(user_id).get());
    }


    @Override
    public void deletewatchlater(Long user_id, Long shortfilm_id) {
        watchlaterdb.deletewacthlater(user_id,shortfilm_id);
    }

}
