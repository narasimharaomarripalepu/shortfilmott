package com.shortfilmott.shortfilmott.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shortfilmott.shortfilmott.entity.comments;
import com.shortfilmott.shortfilmott.entity.credentials;
import com.shortfilmott.shortfilmott.entity.loginmsg;
import com.shortfilmott.shortfilmott.entity.shortfilms;
import com.shortfilmott.shortfilmott.entity.users;
import com.shortfilmott.shortfilmott.entity.watchlater;
import com.shortfilmott.shortfilmott.service.commentservice;
import com.shortfilmott.shortfilmott.service.shortfilmservice;
import com.shortfilmott.shortfilmott.service.userservice;
import com.shortfilmott.shortfilmott.service.watchlaterservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class shortfilmottController {

    @Autowired
    private userservice uservice;

    @Autowired
    private shortfilmservice sservice;

    @Autowired
    private watchlaterservice wservice;

    @Autowired
    private commentservice cservice;
    

    @PostMapping("/login")
    public loginmsg trylogin(@RequestBody credentials credential) {
        return uservice.trylogin(credential);
    }
    

    @PostMapping("/new-user")
    public users saveUser(@RequestBody users user) {
       return uservice.saveUser(user);
    }

    @PostMapping("/recommend-shortfilm/{user_id}")
    public shortfilms recommendShortFilm(@RequestBody shortfilms shortfilm, @PathVariable("user_id") Long user_id) throws IOException{
        return sservice.recommendShortfilm(shortfilm, user_id);
    }

    @PostMapping("/watch-later/{user_id}/{s_id}")
    public watchlater saveMovie(@PathVariable("user_id") Long user_id,@PathVariable("s_id") Long s_id) {
        
        return wservice.saveMovie(user_id,s_id);
    }

    @PostMapping("/rating/{shortfilm_id}/{user_id}")
    public shortfilms rate_shortfilm(@PathVariable("shortfilm_id") Long shortfilm_id, @PathVariable("user_id") Long user_id, @RequestBody shortfilms shortfilm_rating) {
        return sservice.rate_shortfilm(shortfilm_id, user_id, shortfilm_rating);
    }

    @GetMapping("/top-rated")
    public List<shortfilms> topratedfilms() {
        return sservice.topratedfilms();
    }

    @GetMapping("/movie/{s_id}")
    public shortfilms getshortfilm(@PathVariable("s_id") Long shortfilmid) {
        return sservice.getshortfilm(shortfilmid);
    }
    @GetMapping("/genere/{genere}")
    public List<shortfilms> getgenereshortfilms(@PathVariable("genere") String genere) {
        return sservice.getgenerefilms(genere);
    }
    @GetMapping("/watch-later/{user_id}")
    public List<shortfilms> watchlaterfilms(@PathVariable("user_id") Long user_id) {
        return sservice.watchlaterfilms(user_id);
    }
    @GetMapping("/user-details/{user_id}")
    public users getuserdetails(@PathVariable("user_id") Long user_id) {
        return uservice.getuserdetails(user_id);
    }
    @GetMapping("/recommended-films/{user_id}")
    public List<shortfilms> getrecommendedfilms(@PathVariable("user_id") Long user_id) {
        return sservice.getrecommendedfilms(user_id);
    }
    @DeleteMapping("/watch-later/{user_id}/{shortfilm_id}")
    public void deletewatchlater(@PathVariable("user_id") Long user_id, @PathVariable("shortfilm_id") Long shortfilm_id){
        wservice.deletewatchlater(user_id,shortfilm_id);
    }
    @PostMapping("comment/{shortfilm_id}/{user_id}")
    public String postcomment(@PathVariable("user_id") Long user_id, @PathVariable("shortfilm_id") Long shortfilm_id, @RequestParam String comment) {
        return cservice.postcomment(user_id,shortfilm_id,comment);
    }

    @GetMapping("/comments/{shortfilm_id}")
    public List<comments> getcomments(@PathVariable("shortfilm_id") Long shortfilm_id) {
        return cservice.getcomments(shortfilm_id);
    }

    @GetMapping("/search/{shortfilm_name}")
    public List<shortfilms> getsearchresult(@PathVariable("shortfilm_name") String shortfilm_name) {
        return sservice.getsearchresult(shortfilm_name);
    }
    
    
    
    
    
    
    
    
    

    
}
