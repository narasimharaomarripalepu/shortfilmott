package com.shortfilmott.shortfilmott.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortfilmott.shortfilmott.entity.ratings;
import com.shortfilmott.shortfilmott.entity.shortfilms;
import com.shortfilmott.shortfilmott.entity.users;
import com.shortfilmott.shortfilmott.entity.watchlater;
import com.shortfilmott.shortfilmott.repository.shortfilmrepository;
import com.shortfilmott.shortfilmott.repository.userrepository;
import com.shortfilmott.shortfilmott.repository.watchlaterrepository;
import com.shortfilmott.shortfilmott.repository.ratingsrepository;

@Service
public class shortfilmserviceimpl implements shortfilmservice{

    @Autowired
    private userrepository userdb;


    @Autowired
    private shortfilmrepository shortfilmdb;

    @Autowired
    private ratingsrepository ratingsdb;

    @Autowired
    private watchlaterrepository watchlaterdb;


    @Override
    public shortfilms recommendShortfilm(shortfilms shortfilm, Long user_id) throws IOException {
        // shortfilms shortfilm=new shortfilms();
        // shortfilm=new shortfilms();

        users user=userdb.findById(user_id).get();

        // shortfilm.setImage(image.getBytes());
        // shortfilm.setShortfilm_name(shortfilm_name);
        // shortfilm.setDescription(description);
        shortfilm.setUser(user);
        // shortfilm.setLink(link);
        // shortfilm.setRating(rating);
        
        shortfilm= shortfilmdb.save(shortfilm);
        // Long shortfilm_id=shortfilm.getShortfilm_id();
        ratings ratingobj=new ratings();
        ratingobj.setShortfilm(shortfilm);
        ratingobj.setUser(user);
        ratingobj.setRating(shortfilm.getRating());
        ratingobj=ratingsdb.save(ratingobj);

        return shortfilm;

    }


    @Override
    public shortfilms rate_shortfilm(Long shortfilm_id, Long user_id, shortfilms shortfilm_rating) {

        shortfilms shortfilm=shortfilmdb.findById(shortfilm_id).get();
        
        ratings ratingobj=new ratings();

        users user=userdb.findById(user_id).get();

        // if(Objects.nonNull(shortfilm)&&!"".equalsIgnoreCase(shortfilm_rating.getShortfilm_name())){
        //     shortfilm.setShortfilm_name(shortfilm_rating.getShortfilm_name());
        // }

        // if(Objects.nonNull(shortfilm)&&!"".equalsIgnoreCase(shortfilm_rating.getDescription())){
        //     shortfilm.setDescription(shortfilm_rating.getDescription());
        // }

        // if(Objects.nonNull(shortfilm)&&!"".equalsIgnoreCase(shortfilm_rating.getLink())){
        //     shortfilm.setLink(shortfilm_rating.getLink());
        // }

        // if(Objects.nonNull(shortfilm)){
        //     shortfilm.setRecommended_by_id(shortfilm_rating.getRecommended_by_id());
        // }

        double rating=shortfilm.getRating();
        ratingobj.setShortfilm(shortfilm);
        ratingobj.setUser(user);
        ratingobj.setRating(shortfilm_rating.getRating());
        ratingobj = ratingsdb.save(ratingobj);
        List<ratings> ratinglist=ratingsdb.findByShortfilm(shortfilm);
        shortfilm.setRating(((ratinglist.size()-1)*rating+shortfilm_rating.getRating())/(ratinglist.size()));


        return shortfilmdb.save(shortfilm);
    }


    @Override
    public List<shortfilms> topratedfilms() {
        List<shortfilms> toprated=shortfilmdb.findAll();
        Collections.sort(toprated, Collections.reverseOrder());
        return toprated;
    }


    @Override
    public shortfilms getshortfilm(Long shortfilmid) {
        return shortfilmdb.findById(shortfilmid).get();
    }


    @Override
    public List<shortfilms> getgenerefilms(String genere) {
        
        return shortfilmdb.findAllByGenere(genere);
    }


    @Override
    public List<shortfilms> watchlaterfilms(Long user_id) {
        List<watchlater> watchlaters= new ArrayList<>();
        watchlaters = watchlaterdb.findAllByUser(userdb.findById(user_id).get());
        List<shortfilms> sList=new ArrayList<>();
        for(watchlater watchl:watchlaters){
            sList.add(watchl.getShortfilm());
        }
        return sList;
    
    }


    @Override
    public List<shortfilms> getrecommendedfilms(Long user_id) {
        return shortfilmdb.findAllByUser(userdb.findById(user_id).get());
    }


    @Override
    public List<shortfilms> getsearchresult(String shortfilm_name) {
        List<shortfilms> all=new ArrayList<>();
        all=shortfilmdb.findAll();
        List<shortfilms> result=new ArrayList<>();
        for(int i=0;i<all.size();i++){
            if((all.get(i).getShortfilm_name()).toLowerCase().equals(shortfilm_name.toLowerCase())){
                result.add(all.get(i));
            }
        }
        return result;

    }

   
   

}
