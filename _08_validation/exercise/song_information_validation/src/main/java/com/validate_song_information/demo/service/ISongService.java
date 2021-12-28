package com.validate_song_information.demo.service;

import com.validate_song_information.demo.dto.SongDTO;
import com.validate_song_information.demo.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    void save(SongDTO songDto);
}
