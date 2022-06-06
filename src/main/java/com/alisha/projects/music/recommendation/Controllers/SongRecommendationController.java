package com.alisha.projects.music.recommendation.Controllers;

import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Service.SongsRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongRecommendationController {
    @Autowired
    SongsRecommendationService songsRecommendationService;

    @GetMapping("/recommend/songs/{userId}")
    List<Song> recommendSongs(@PathVariable Long userId)
    {
        System.out.println("userid: "+userId);
        return songsRecommendationService.recommendSongs(userId);
    }
}
