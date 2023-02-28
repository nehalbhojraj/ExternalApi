package com.app.thirdparty.controller;

import com.app.thirdparty.Model.DetectRequest;
import com.app.thirdparty.service.ServiceLayer;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/hello")
    public String myController(){
        return "Hello";
    }

    @GetMapping("/thirdParty")
    public Object detectLanguage(@RequestBody DetectRequest detectRequest) throws UnirestException {
        return serviceLayer.consumeApi(detectRequest.getText());

    }
}
