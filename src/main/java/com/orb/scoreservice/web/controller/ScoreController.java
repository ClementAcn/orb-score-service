package com.orb.scoreservice.web.controller;

import com.orb.scoreservice.dao.ScoreDao;
import com.orb.scoreservice.model.Score;
import com.orb.scoreservice.web.exceptions.ScoreNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "API pour les opérations CRUD sur les notes")
@RestController
@RequestMapping(value = "/")
public class ScoreController {

    @Autowired
    private ScoreDao scoreDao;

    @GetMapping(value = "/")
    public String accueilAPI(){
        return "Service REST de gestion des scores de l'application ORB";
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes")
    @GetMapping(value = "/score")
    public List<Score> getAll(){
        System.out.println("here");
        return scoreDao.findAll();
    }

    @ApiOperation(value = "Récupère une note en fonction de son ID")
    @GetMapping(value = "/score/{id}")
    public Score getById(@PathVariable int id) throws ScoreNotFoundException {
        Score score = scoreDao.findById(id);
        if (score == null)
            throw new ScoreNotFoundException("La note avec l'id " + id + " n'existe pas");
        return scoreDao.findById(id);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un utilisateur")
    @GetMapping(value = "/score/findByUserId/{id}")
    List<Score> getByUserId(@PathVariable int id){
        return scoreDao.findByUserId(id);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un lieu")
    @GetMapping(value = "/score/findByPlaceId/{id}")
    List<Score> getByPlaceId(@PathVariable int id){
        return scoreDao.findByPlaceId(id);
    }

}
