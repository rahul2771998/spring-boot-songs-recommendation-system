package com.alisha.projects.music.recommendation.Controllers;

import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Service.SongInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    @Autowired
    SongInfoService songInfoService;

    @GetMapping("get/all/songs")
    Song getAllSongs(){
        return (Song) songInfoService.getAllSongs();
    }

    @GetMapping("get/song")
    Song getSong(@RequestParam ("songId") Long songId){
        System.out.println("SongId:"+songId);
        return songInfoService.getSong(songId);
    }

    @PostMapping("add/song")
    Song addSong(@RequestBody Song song){
        return songInfoService.addSong(song);
    }

    @DeleteMapping("delete/song/{songId}")
    Song deleteSong(@PathVariable Long songId){
        return songInfoService.deleteSong(songId);
    }

}
