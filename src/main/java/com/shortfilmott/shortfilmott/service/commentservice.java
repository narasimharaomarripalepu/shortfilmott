package com.shortfilmott.shortfilmott.service;

import java.util.List;

import com.shortfilmott.shortfilmott.entity.comments;

public interface commentservice {

    String postcomment(Long user_id, Long shortfilm_id, String comment);

    List<comments> getcomments(Long shortfilm_id);

}
