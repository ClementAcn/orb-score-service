package com.orb.scoreservice.dao;

import com.orb.scoreservice.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreDao extends JpaRepository<Score, Integer> {

    List<Score> findAll();

    Score findById(int id);

    @Query("SELECT s from Score s where s.id_user = :id")
    List<Score> findByUserId(@Param("id") int id);

    @Query("SELECT s from Score s where s.id_place = :id")
    List<Score> findByPlaceId(@Param("id") int id);

    //public List<Score> findNLastById_user(int n, int id);

    //public List<Score> findNLastById_place(int n, int id);

    //public Score save(Score score);
}
