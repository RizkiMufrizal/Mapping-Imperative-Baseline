package org.rizki.mufrizal.baseline.controller;

import org.rizki.mufrizal.baseline.mapper.object.server.request.HelloServerRequest;
import org.rizki.mufrizal.baseline.mapper.object.server.response.GeneralServerResponse;
import org.rizki.mufrizal.baseline.restclient.HelloRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class HelloController {

    @Autowired
    private HelloRestClient helloRestClient;

    @PostMapping(value = "/hello")
    public ResponseEntity<?> sayHello(@RequestBody HelloServerRequest helloServerRequest) {
        GeneralServerResponse generalServerResponse = helloRestClient.sayHello(helloServerRequest);
        return new ResponseEntity<>(generalServerResponse.getBody(), HttpStatus.valueOf(generalServerResponse.getHttpStatus()));
    }

}