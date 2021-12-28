package com.validate_song_information.demo.service.impl;

import com.validate_song_information.demo.dto.SongDTO;
import com.validate_song_information.demo.model.Song;
import com.validate_song_information.demo.service.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    List<Song> songList;


    @Override
    public List<Song> getAll() {
        return null;
    }

    @Override
    public void save(SongDTO songDto) {

    }
}
