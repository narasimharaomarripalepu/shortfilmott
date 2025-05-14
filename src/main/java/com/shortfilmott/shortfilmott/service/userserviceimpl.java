package com.shortfilmott.shortfilmott.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shortfilmott.shortfilmott.entity.credentials;
import com.shortfilmott.shortfilmott.entity.loginmsg;
import com.shortfilmott.shortfilmott.entity.users;
import com.shortfilmott.shortfilmott.repository.userrepository;

@Service
public class userserviceimpl implements userservice {

    @Autowired 
    private userrepository userdb;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public users saveUser(users user) {

        String encryptedpassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedpassword);
        return userdb.save(user);
    }

    @Override
    public loginmsg trylogin(credentials credential) {
        users user=userdb.findByUserEmail(credential.getUser_email());
        loginmsg msg=new loginmsg();
        if(user != null && passwordEncoder.matches(credential.getPassword(), user.getPassword())){
            msg.setUser_id(user.getUser_id());
            msg.setMsg("true");
            return msg;
        }
        msg.setUser_id(user.getUser_id());
        msg.setMsg("false");
        return msg;
    }

    @Override
    public users getuserdetails(Long user_id) {
        return userdb.findById(user_id).get();
    }

}
