package com.shortfilmott.shortfilmott.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shortfilmott.shortfilmott.entity.comments;
import com.shortfilmott.shortfilmott.repository.commentrepository;
import com.shortfilmott.shortfilmott.repository.shortfilmrepository;
import com.shortfilmott.shortfilmott.repository.userrepository;


@Service
public class commentserviceimpl implements commentservice {

    @Autowired
    private commentrepository commentdb;

    @Autowired
    private shortfilmrepository shortfilmdb;

    @Autowired
    private userrepository userdb;



    @Override
    public String postcomment(Long user_id, Long shortfilm_id, String comment) {
        
        comments commentobj=new comments();
        commentobj.setShortfilm(shortfilmdb.findById(shortfilm_id).get());
        commentobj.setUser(userdb.findById(user_id).get());
        commentobj.setComment(comment);

        commentobj= commentdb.save(commentobj);

        return commentobj.getComment();
        
    }



    @Override
    public List<comments> getcomments(Long shortfilm_id) {
        return commentdb.findAllByShortfilm(shortfilmdb.findById(shortfilm_id).get());
    }

}
