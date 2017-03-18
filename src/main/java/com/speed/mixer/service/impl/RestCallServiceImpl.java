package com.speed.mixer.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.speed.mixer.model.AuthorizedUser;
import com.speed.mixer.model.RestCallError;
import com.speed.mixer.service.RestCallService;
import com.speed.mixer.util.RestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by sambit on 3/18/2017.
 */
@Service("httpService")
public class RestCallServiceImpl implements RestCallService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<Object> callRest() {
        String url = "http://localhost:3000/testresttemplate";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhYmN4eXoiLCJpYXQiOjE0ODk4NTUyNDUsInN1YiI6ImFiY0BhYmMuY29tIiwiZXhwIjoxNDg5ODU1NTQ1fQ.6EnkSjQlxBwI0SY2x-byJ4gRwzhF5uTU172gJzd_9Pk");
        HttpEntity<?> requestEntity = new HttpEntity<Object>(headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
        String responsebody = response.getBody();

        System.out.println("response----:"+responsebody);
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<Object> responseEntity= null;
        try {
            if (RestUtil.isError(response.getStatusCode())) {
                RestCallError restCallError = objectMapper.readValue(responsebody, RestCallError.class);
                //responseEntity = new HttpEntity<Object>(restCallError,responseHeaders);
                responseEntity = new ResponseEntity<Object>(restCallError, responseHeaders, HttpStatus.BAD_REQUEST);
            }else{
                AuthorizedUser authorizedUser  = objectMapper.readValue(responsebody, AuthorizedUser.class);
                //responseEntity = new HttpEntity<Object>(authorizedUser,responseHeaders);
                responseEntity = new ResponseEntity<Object>(authorizedUser, responseHeaders, HttpStatus.BAD_REQUEST);
            }
        } catch (IOException e) {
            System.out.println("IOException occurs");
        }

        return responseEntity;
    }
}
