package com.orb.scoreservice.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ScoreNotFoundException extends Exception{
    public ScoreNotFoundException(String s){
        super(s);
    }
}
