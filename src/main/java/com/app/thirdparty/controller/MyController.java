package com.app.thirdparty.controller;

import com.app.thirdparty.Model.DetectRequest;
import com.app.thirdparty.Model.Employee;
import com.app.thirdparty.service.ServiceLayer;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/rest")
    public ResponseEntity<String> consumeRest(){
        return new ResponseEntity<>(serviceLayer.consumeRest(), HttpStatus.OK);
    }

    @GetMapping("/unirest")
    public Object detectLanguage(@RequestBody DetectRequest detectRequest) throws UnirestException {
        return serviceLayer.consumeApi(detectRequest.getText());

    }
}
