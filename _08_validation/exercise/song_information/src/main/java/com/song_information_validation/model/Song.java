package com.song_information_validation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @Column
    private Integer id;
    @Column
    private String song_name;
    @Column
    private String artist_name;
    @Column
    private String kind_of;

    public Song() {
    }

    public Song(Integer id, String song_name, String artist_name, String kind_of) {
        this.id = id;
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.kind_of = kind_of;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getKind_of() {
        return kind_of;
    }

    public void setKind_of(String kind_of) {
        this.kind_of = kind_of;
    }
}
