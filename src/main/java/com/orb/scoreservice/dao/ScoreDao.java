package com.orb.scoreservice.dao;

import com.orb.scoreservice.model.Score;

import java.util.List;

public interface ScoreDao {
    public List<Score> findAll();
    public Score findById(int id);
    public List<Score> findByUserId(int id);
    public List<Score> findByPlaceId(int id);
    public List<Score> findNLastByUserId(int n, int id);
    public List<Score> findNLastByPlaceId(int n, int id);
    public Score save(Score score);
}
