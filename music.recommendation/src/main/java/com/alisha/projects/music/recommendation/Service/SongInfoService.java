package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.Song;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SongInfoService {
    public Song addSong(Song song);
    public List<Song> getAllSongs();
    public Song getSong(Long Id);
    public Song deleteSong(Long Id);
}
