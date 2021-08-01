package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.model.UserModel;
import com.trackeasy.repository.UserModelRepository;

// @CrossOrigin(origins = "http://localhost:8081")
@RestController
public class SignupController {

  @Autowired
  private UserModelRepository userModelRepository;

 @Autowired
 BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping("/signup")
  public boolean saveUser(@RequestBody UserModel user) {
      System.out.println("inside signup "+user.getEmail());
      String email = user.getEmail();
       System.out.println("inside signup 1 ");
      UserModel userModel = userModelRepository.findByEmail(email).orElse(null);
      System.out.println("inside signup 2 ");
      //System.out.print(userModel.getUserId());
      if(userModel != null)
      {
          return false;
      }
      System.out.println("inside signup 3 "+user.getEmail());
      user.setActive(true);
      
      if(user.getEmail().equals("admin@trackeasy") ) {
      	user.setRole("admin");
      }
      else {
    	  return false;
      }
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      
      System.out.println("inside signup last before "+user.getEmail());
      userModelRepository.save(user);
      System.out.println("inside signup last "+user.getEmail());
      System.out.println(true);
      return true;

  }

}
