package com.orb.scoreservice.web.controller;

import com.orb.scoreservice.dao.ScoreDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "API pour les opérations CRUD sur les notes")
@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreDao scoreDao;

}
