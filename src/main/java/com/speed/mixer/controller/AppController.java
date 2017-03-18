package com.speed.mixer.controller;

import com.speed.mixer.model.AuthorizedUser;
import com.speed.mixer.service.RestCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sambit on 3/12/2017.
 */
@RestController
@RequestMapping("/api")
public class AppController {



    @Autowired
    @Qualifier("httpService")
    RestCallService restCallService;

    @RequestMapping(value = { "/", "/test" }, method = RequestMethod.GET)
    public Object testOk() {
        return "tested OK";
    }

    @RequestMapping(value={"/resttemplateerrorcheck"}, method=RequestMethod.POST)
    public ResponseEntity<Object> resttemplateerrorcheck(){
        AuthorizedUser testuser = new AuthorizedUser();
        /*testuser.setToken("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhYmN4eXoiLCJpYXQiOjE0ODk4NTUyNDUsInN1YiI6ImFiY0BhYmMuY29tIiwiZXhwIjoxNDg5ODU1NTQ1fQ.6EnkSjQlxBwI0SY2x-byJ4gRwzhF5uTU172gJzd_9Pk");
        testuser.setLastname("Mishra");
        testuser.setFirstname("Sambit");
        testuser.setEmail("sambit@gmail.com");*/
        //return testuser;
        ResponseEntity<Object> responseEntity = restCallService.callRest();
        return responseEntity;

    }
}
