package com.shortfilmott.shortfilmott.service;

import java.io.IOException;
import java.util.List;


import com.shortfilmott.shortfilmott.entity.shortfilms;


public interface shortfilmservice {


    public shortfilms recommendShortfilm(shortfilms shortfilm, Long user_id) throws IOException;


    public shortfilms rate_shortfilm(Long shortfilm_id, Long user_id, shortfilms shortfilm_rating);


    public List<shortfilms> topratedfilms();


    public shortfilms getshortfilm(Long shortfilmid);


    public List<shortfilms> getgenerefilms(String genere);

    List<shortfilms> watchlaterfilms(Long user_id);


    public List<shortfilms> getrecommendedfilms(Long user_id);


    public List<shortfilms> getsearchresult(String shortfilm_name);


}
