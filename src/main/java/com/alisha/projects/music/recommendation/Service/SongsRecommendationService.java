package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.Song;

import java.util.List;

public interface SongsRecommendationService {
    List<Song> recommendSongs(Long userId);
}
