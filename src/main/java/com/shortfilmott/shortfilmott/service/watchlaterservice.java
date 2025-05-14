package com.shortfilmott.shortfilmott.service;

import java.util.List;


import com.shortfilmott.shortfilmott.entity.watchlater;

public interface watchlaterservice {

    watchlater saveMovie(Long user_id, Long s_id);

    List<watchlater> watchlaterfilms(Long user_id);

    void deletewatchlater(Long user_id, Long shortfilm_id);

}
