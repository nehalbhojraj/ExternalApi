package com.app.thirdparty.service;


import com.app.thirdparty.Model.Company;
import com.app.thirdparty.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    private RestTemplate restTemplate;

    public ServiceLayer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    //unirest
    public Object consumeApi(String text) throws UnirestException {

        Object response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2/detect")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "fc83b65550mshd8e0c4bb230e74dp1dd902jsnb552aee7dda7")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .body("q=English%20is%20hard%2C%20but%20detectably%20so").asString();

        return response;
    }

    //In string
    public String consumeRest(){
        return  restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees",String.class);
    }

    //Convert String to Json and Json to String
    public String consumeRestAndReturnJsonAndBacktoString() throws IOException {
        // Make REST API call and get response as a String
        String responseString = restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);

        // Create ObjectMapper instance to convert String to JSON
        ObjectMapper mapper = new ObjectMapper();

        // Convert String to JSON object
        Object responseJson = mapper.readValue(responseString, Object.class);

        // Convert JSON object back to String
        String jsonResponseString = mapper.writeValueAsString(responseJson);

        // Return JSON response String
        return jsonResponseString;
    }

    public Company consumeRestAndReturnJson() throws IOException {

        // Make REST API call and get response as a String
        String responseString = restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", String.class);

        // Create ObjectMapper instance to convert String to JSON
        ObjectMapper mapper = new ObjectMapper();

        // Convert String to JSON object
        Company responseJson = mapper.readValue(responseString, Company.class);

        // Return JSON response String
        return  responseJson;
    }

//    //DirectJson
//    public Company consumeRest1() throws JsonProcessingException {
//        String  company=  restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employee/1",String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        Company responseJson = mapper.readValue(company, Company.class);
//        return responseJson;
//    }

    //convert to json
    public Employee consumeRest2() throws JsonProcessingException {

        String emp = restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employee/1", String.class);

        JSONObject json = new JSONObject(emp);
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.readValue(json.get("data").toString(), Employee.class);

        return employee;
    }
}

