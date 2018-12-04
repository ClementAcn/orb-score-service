package com.orb.scoreservice.web.controller;

import com.orb.scoreservice.dao.ScoreDao;
import com.orb.scoreservice.model.Score;
import com.orb.scoreservice.web.exceptions.ScoreNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "API pour les opérations CRUD sur les notes")
@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreDao _scoreDao;

    @ApiOperation(value = "Récupère la liste de toutes les notes")
    @GetMapping(value = "/")
    public ResponseEntity<List<Score>> getAll(){
        List<Score> scores = _scoreDao.findAll();
        if(scores.isEmpty())
            return new ResponseEntity<List<Score>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Score>>(scores, HttpStatus.OK);
    }

    @ApiOperation(value  = "Récupère une note en fonction de son ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Score> getById(@PathVariable("id") int id) throws ScoreNotFoundException {
        Score score = _scoreDao.findById(id);
        if (score == null)
            throw new ScoreNotFoundException("La note avec l'id " + id + " n'existe pas");
        return new ResponseEntity<Score>(score, HttpStatus.OK);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un utilisateur")
    @GetMapping(value = "/findByUserId/{id}")
    List<Score> getByUserId(@PathVariable("id") int id){
        return _scoreDao.findByUserId(id);
    }

    @ApiOperation(value = "Récupère la liste de toutes les notes d'un lieu")
    @GetMapping(value = "/findByPlaceId/{id}")
    List<Score> getByPlaceId(@PathVariable("id") int id){
        return _scoreDao.findByPlaceId(id);
    }

    @ApiOperation(value = "Récupère la liste des N dernières notes d'un utilisateur")
    @GetMapping(value = "/findNLastUser")
    List<Score> getNLastByIdUser(@RequestParam("n") int n, @RequestParam("id") int id){
        return _scoreDao.findNLastById_user(n, id);
    }

    @ApiOperation(value = "Récupère la liste des N dernières notes d'une place")
    @GetMapping(value = "/findNLastPlace")
    List<Score> getNLastByIdPlace(@RequestParam("n") int n, @RequestParam("id") int id){
        return _scoreDao.findNLastById_place(n, id);
    }

    @ApiOperation(value = "Récupère les N dernières notes")
    @GetMapping(value = "/findNLast")
    List<Score> getNLast(@RequestParam("n") int n){
        return _scoreDao.findNLast(n);
    }

    @ApiOperation(value = "Création d'une note")
    @PostMapping(value = "/")
    ResponseEntity<Score> create(@RequestBody Score score){
        Score scoreAdded = _scoreDao.save(score);

        if(scoreAdded == null)
            return ResponseEntity.noContent().build();

        URI loc = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(scoreAdded.getId())
                .toUri();

        return ResponseEntity.created(loc).build();
    }

    @ApiOperation(value = "Mise à jour d'une note")
    @PutMapping(value = "/")
    Score update(@RequestBody Score score){
        return _scoreDao.save(score);
    }

    @ApiOperation(value = "Suppression d'une note")
    @DeleteMapping(value = "/")
    void delete(@RequestBody Score score){
        _scoreDao.delete(score);
    }

}
