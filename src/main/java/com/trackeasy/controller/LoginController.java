package com.trackeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trackeasy.dto.AuthenticationResponse;
import com.trackeasy.dto.Login;
import com.trackeasy.model.JwtModel;
import com.trackeasy.model.UserModel;
import com.trackeasy.repository.JwtRepository;
import com.trackeasy.repository.UserModelRepository;
import com.trackeasy.service.MyUserDetailsService;
import com.trackeasy.util.JwtUtil;

@CrossOrigin(origins = "http://localhost:8081")

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;
    
    @Autowired
    UserModelRepository userModelRepository;
    
    @Autowired
    JwtRepository jwtRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Login login) throws Exception {
        System.out.println("inside login 1");

        try {
        	 System.out.println("inside login 1.1"+ login.getEmail() + "  " + login.getPassword());
        	 
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
            );
            System.out.println("inside login controller 2.........");
            UserModel userModel = userModelRepository.findByEmail(login.getEmail()).orElse(null);
            System.out.println("inside login controller 2.1.................");
            if(userModel==null) {
            	System.out.println("inside login controller null");
            }
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(login.getEmail());
            System.out.println("inside login controller 2.1");
       	 	final String role = userModel.getRole();
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            
            JwtModel jwtModel = jwtRepository.findByToken(jwt).orElse(null); 
            if(jwtModel != null) {
            	jwtRepository.delete(jwtModel);
            }

            return ResponseEntity.ok(new AuthenticationResponse(role,true,jwt));
        }
        
        catch(DisabledException e) {
        	return new ResponseEntity<String>("account disabled", HttpStatus.UNAUTHORIZED);
        }
        catch (BadCredentialsException e) {
        	System.out.println("bad creds");
        	return new ResponseEntity<String>("wrong credentials", HttpStatus.UNAUTHORIZED);
        }
        catch(Exception e) {
        	System.out.println("insider exception  " + e);
        	return new ResponseEntity<String>("wrong ", HttpStatus.UNAUTHORIZED);
        	 
        }
       
    }
}    
    
    
