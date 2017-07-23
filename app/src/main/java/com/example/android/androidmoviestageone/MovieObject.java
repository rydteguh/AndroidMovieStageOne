package com.example.android.androidmoviestageone;

/**
 * Created by rydteguh on 7/10/2017.
 */

public class MovieObject {

    private String name;
    private String photo;
    private int id;
    private String release_date;
    private String overview;
    private String rating;
    private String duration;



    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getOverview() {
        return overview;
    }

    public String getRating() {
        return rating;
    }

    public MovieObject(String name, String photo, int id, String release_date, String overview, String rating) {
        this.name = name;
        this.photo = photo;
        this.id = id;
        this.release_date = release_date;
        this.overview = overview;
        this.rating = rating;
    }

    public MovieObject() {
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration() {

        return duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
