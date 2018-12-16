package com.orb.scoreservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_user;

    private String id_place;

    @Min(value = 0)
    @Max(value = 5)
    private int score;

    private String comment;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp creation_date; // Date quand la note a ete creee

    @UpdateTimestamp
    private Timestamp update_date; // Stockera la date de la derniere maj de la note

    public Score(int id, int id_user, String id_place, int score, String comment, Timestamp creation_date, Timestamp update_date) {
        this.id = id;
        this.id_user = id_user;
        this.id_place = id_place;
        this.score = score;
        this.comment = comment;
        this.creation_date = creation_date;
        this.update_date = update_date;
    }

    public Score() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getId_place() {
        return id_place;
    }

    public void setId_place(String id_place) {
        this.id_place = id_place;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_place=" + id_place +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", creation_date=" + creation_date +
                ", update_date=" + update_date +
                '}';
    }
}