package com.example.android.androidmoviestageone;

/**
 * Created by rydteguh on 7/10/2017.
 */

public class MovieObject {

    private String name;
    private String photo;
    private int id;


    public MovieObject(String name, String photo, int id) {
        this.name = name;
        this.photo = photo;
        this.id = id;
    }

    public MovieObject() {
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
