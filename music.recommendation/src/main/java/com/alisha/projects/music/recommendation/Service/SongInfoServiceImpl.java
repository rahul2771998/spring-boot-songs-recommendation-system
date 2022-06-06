package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongInfoServiceImpl implements SongInfoService{
@Autowired
    SongRepository songRepository;
    @Override
    public Song addSong(Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public List<Song> getAllSongs() {
       // List<Song> list = songRepository.findAll(); // poori repo lene ke liye findAll
        return songRepository.findAll();
    }

    @Override
    public Song getSong(Long Id) {
        return songRepository.findById(Id).get();
    }

    @Override
    public Song deleteSong(Long Id) {
        Song song = songRepository.findById(Id).get();
        songRepository.delete(song);
        return song;
    }
}
