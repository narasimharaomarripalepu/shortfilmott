package com.shortfilmott.shortfilmott.service;


import com.shortfilmott.shortfilmott.entity.credentials;
import com.shortfilmott.shortfilmott.entity.loginmsg;
import com.shortfilmott.shortfilmott.entity.users;

public interface userservice {

    public users saveUser(users user);

    public loginmsg trylogin(credentials credential);

    public users getuserdetails(Long user_id);

}
