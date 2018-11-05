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
    List<Score> findByUserId(@Param("id")int id);

    @Query("SELECT s from Score s where s.id_place = :id")
    List<Score> findByPlaceId(@Param("id")int id);

    @Query(value = "SELECT * from Score s where s.id_user = :id order by s.creation_date limit :n", nativeQuery = true)
    List<Score> findNLastById_user(@Param("n")int n, @Param("id")int id);

    @Query(value = "SELECT * from Score s where s.id_place = :id order by s.creation_date limit :n", nativeQuery = true)
    List<Score> findNLastById_place(@Param("n")int n, @Param("id")int id);

    Score save(Score score);

    void delete(Score score);
}
