package com.trackeasy.firebase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class RegistryController {

  private final FcmClient fcmClient;

  public RegistryController(FcmClient fcmClient) {
    this.fcmClient = fcmClient;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
 @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> register( @RequestBody String tokendata) {
	  Mono<String> token = Mono.just(tokendata);
	  System.out.println("inside register controller");
	 
    return token.doOnNext(t -> this.fcmClient.subscribe("placements", t)).then();
  }


}