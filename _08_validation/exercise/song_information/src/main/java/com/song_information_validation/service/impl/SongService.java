package com.song_information_validation.service.impl;

import com.song_information_validation.dto.SongDTO;
import com.song_information_validation.model.Song;
import com.song_information_validation.repository.ISongRepository;
import com.song_information_validation.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(SongDTO songDto) {
        Song song = new Song(songDto.getId(),songDto.getSong_name(), songDto.getArtist_name(), songDto.getKind_of());
        songRepository.save(song);
    }
}
