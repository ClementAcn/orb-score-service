package com.orb.scoreservice.dao.impl;

import com.orb.scoreservice.dao.ScoreDao;
import com.orb.scoreservice.model.Score;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDaoImpl implements ScoreDao {

    // On va garder le modèle Dao et DaoImpl pour se permettre une meilleure compréhension des requêtes
    // et pouvoir les écrire par nous même

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public Score findById(int id) {
        return null;
    }

    @Override
    public List<Score> findByUserId(int id) {
        return null;
    }

    @Override
    public List<Score> findByPlaceId(int id) {
        return null;
    }

    @Override
    public List<Score> findNLastByUserId(int n, int id) {
        return null;
    }

    @Override
    public List<Score> findNLastByPlaceId(int n, int id) {
        return null;
    }

    @Override
    public Score save(Score score) {
        return null;
    }
}
