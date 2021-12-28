package com.validate_song_information.demo.model;

public class Song {
    private String song_name;
    private String artist_name;
    private String kind_of;

    public Song() {
    }

    public Song(String song_name, String artist_name, String kind_of) {
        this.song_name = song_name;
        this.artist_name = artist_name;
        this.kind_of = kind_of;
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
