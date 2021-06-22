package com.trackeasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.trackeasy.model.UserModel;
import com.trackeasy.repository.UserModelRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserModelRepository userModelRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	System.out.println("inside the myuserdetails service");
        UserModel userModel = userModelRepository.findByEmail(userName).orElse(null);
        
        if(userModel == null) {
        	throw new UsernameNotFoundException("username not found " + userName);
        }
     
//        UserModel serModel = userModelRepository.findByEmail(userName).orElseThrow();
//        System.out.println(serModel.getEmail()+" " + serModel.getPassword());
        //return userModel.map(MyUserDetails::new).get();
        return new MyUserDetails(userModel);
    }


}