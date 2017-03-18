package com.speed.mixer.service;

import org.springframework.http.ResponseEntity;

/**
 * Created by sambit on 3/18/2017.
 */
public interface RestCallService {

    public ResponseEntity<Object> callRest();
}
