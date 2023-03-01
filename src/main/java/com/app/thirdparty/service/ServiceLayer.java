package com.app.thirdparty.service;


import com.app.thirdparty.Model.Employee;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {

    @Autowired
    private RestTemplate restTemplate;



    public Object consumeApi(String text) throws UnirestException {

        Object response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2/detect")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "fc83b65550mshd8e0c4bb230e74dp1dd902jsnb552aee7dda7")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .body("q=English%20is%20hard%2C%20but%20detectably%20so").asString();

        return response;
    }

    public String consumeRest(){
        return  restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees",String.class);

    }
}
