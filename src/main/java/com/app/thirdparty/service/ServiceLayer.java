package com.app.thirdparty.service;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    public Object consumeApi(String text) throws UnirestException {

        Object response = Unirest.post("https://google-translate1.p.rapidapi.com/language/translate/v2/detect")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("Accept-Encoding", "application/gzip")
                .header("X-RapidAPI-Key", "fc83b65550mshd8e0c4bb230e74dp1dd902jsnb552aee7dda7")
                .header("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .body("q=English%20is%20hard%2C%20but%20detectably%20so")
                .asString();
        return response;
    }

}
