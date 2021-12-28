package com.song_information_validation.service;

import com.song_information_validation.dto.SongDTO;
import com.song_information_validation.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> getAll();
    void save(SongDTO songDto);
}
