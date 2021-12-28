package com.song_information_validation.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {
    private Integer id;
    @NotEmpty(message = "Name of the song is not empty")
    @Size(max = 800)
    private String song_name;
    @NotEmpty(message = "Name of the artist is not empty")
    @Size(max = 300)
    private String artist_name;
    @NotEmpty(message = "Kind of the song is not empty")
    @Size(max = 300)
    private String kind_of;

    public SongDTO() {
    }

    public SongDTO(Integer id, @NotEmpty(message = "Name of the song is not empty") @Size(max = 800) String song_name, @NotEmpty(message = "Name of the artist is not empty") @Size(max = 300) String artist_name, @NotEmpty(message = "Kind of the song is not empty") @Size(max = 300) String kind_of) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDTO songDTO = (SongDTO) target;
        if(songDTO.song_name.matches("[@;,.= -+…]+")){
            errors.rejectValue("song_name","song_name.invalidFormat");
        }
        if(songDTO.artist_name.matches("[@;,.= -+…]+")){
            errors.rejectValue("artist_name","artist_name.invalidFormat");
        }
        if(songDTO.kind_of.matches("[@;,.= -+…]+")){
            errors.rejectValue("kind_of","kind_of.invalidFormat");
        }
    }
}
