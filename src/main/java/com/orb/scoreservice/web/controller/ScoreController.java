package com.orb.scoreservice.web.controller;

import com.orb.scoreservice.dao.ScoreDao;
import com.orb.scoreservice.model.Score;
import com.orb.scoreservice.web.exceptions.ScoreNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public Score getById(@PathVariable("id") int id) throws ScoreNotFoundException {
        Score score = scoreDao.findById(id);
        if (score == null)
            throw new ScoreNotFoundException("La note avec l'id " + id + " n'existe pas");
        return scoreDao.findById(id);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un utilisateur")
    @GetMapping(value = "/score/findByUserId/{id}")
    List<Score> getByUserId(@PathVariable("id") int id){
        return scoreDao.findByUserId(id);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un lieu")
    @GetMapping(value = "/score/findByPlaceId/{id}")
    List<Score> getByPlaceId(@PathVariable("id") int id){
        return scoreDao.findByPlaceId(id);
    }

    @ApiOperation(value = "Récupère la liste des N dernières notes d'un utilisateur")
    @GetMapping(value = "/score/findNLastUser")
    List<Score> getNLastByIdUser(@RequestParam("n") int n, @RequestParam("id") int id){
        return scoreDao.findNLastById_user(n, id);
    }

    @ApiOperation(value = "Récupère la liste des N dernières notes d'une place")
    @GetMapping(value = "/score/findNLastPlace")
    List<Score> getNLastByIdPlace(@RequestParam("n") int n, @RequestParam("id") int id){
        return scoreDao.findNLastById_place(n, id);
    }

    @ApiOperation(value = "Création d'une note")
    @PostMapping(value = "/score/create")
    Score create(@RequestBody Score score){
        return scoreDao.save(score);
    }

    @ApiOperation(value = "Mise à jour d'une note")
    @PutMapping(value = "/score/update")
    Score update(@RequestBody Score score){
        return scoreDao.save(score);
    }

    @ApiOperation(value = "Suppression d'une note")
    @DeleteMapping(value = "/score/delete")
    void delete(@RequestBody Score score){
        scoreDao.delete(score);
    }

}
