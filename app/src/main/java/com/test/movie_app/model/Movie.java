package com.test.movie_app.model;

import java.util.Date;

public class Movie {

    private int id;
    private String movie_title;
    private String movie_genre;
    private int movie_attendance;
    private String movie_year;

    public Movie(){
    }

    public Movie(int id, String movie_title, String movie_genre, int movie_attendance, String movie_year) {
        this.id = id;
        this.movie_title = movie_title;
        this.movie_genre = movie_genre;
        this.movie_attendance = movie_attendance;
        this.movie_year = movie_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_genre() {
        return movie_genre;
    }

    public void setMovie_genre(String movie_genre) {
        this.movie_genre = movie_genre;
    }

    public int getMovie_attendance() {
        return movie_attendance;
    }

    public void setMovie_attendance(int movie_attendance) {
        this.movie_attendance = movie_attendance;
    }

    public String getMovie_year() {
        return movie_year;
    }

    public void setMovie_year(String movie_year) {
        this.movie_year = movie_year;
    }
}
