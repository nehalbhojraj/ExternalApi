package com.app.thirdparty.controller;

import com.app.thirdparty.Model.Company;
import com.app.thirdparty.Model.DetectRequest;
import com.app.thirdparty.Model.Employee;
import com.app.thirdparty.service.ServiceLayer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping("/unirest")
    public Object detectLanguage(@RequestBody DetectRequest detectRequest) throws UnirestException {
        return serviceLayer.consumeApi(detectRequest.getText());

    }
    //In string
    @GetMapping("/rest")
    public ResponseEntity<String> consumeEmployeesString(){
        return new ResponseEntity<>(serviceLayer.consumeRest(), HttpStatus.OK);
    }
    //Convert String to Json and Json to String
    @GetMapping("/rest11")
    public ResponseEntity<String> CompanyEmplyeesInString() throws IOException {
        return new ResponseEntity<>(serviceLayer.consumeRestAndReturnJsonAndBacktoString(), HttpStatus.OK);
    }
    //Convert String to Json
    @GetMapping("/rest111")
    public Company CompanyEmplyeesInJson() throws IOException {
        return serviceLayer.consumeRestAndReturnJson();
    }

//    //SingleEmployeeJson
//    @GetMapping("/rest1")
//    public Company consumeRest1() throws JsonProcessingException {
//        return serviceLayer.consumeRest1();
//    }

    //convert to json only data
    @GetMapping("/rest2")
    public Employee consumeRest2() throws JsonProcessingException {
        return serviceLayer.consumeRest2();
    }

}
