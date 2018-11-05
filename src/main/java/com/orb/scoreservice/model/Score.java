package com.orb.scoreservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int id_user;

    private int id_place;

    private int score;

    private String comment;

    @CreationTimestamp
    private Date creation_date; // Date quand la note a été créée

    @UpdateTimestamp
    private Date update_date; // Stockera la date de la dernière maj de la note

    public Score(int id, int id_user, int id_place, int score, String comment, Date creation_date, Date update_date) {
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

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
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