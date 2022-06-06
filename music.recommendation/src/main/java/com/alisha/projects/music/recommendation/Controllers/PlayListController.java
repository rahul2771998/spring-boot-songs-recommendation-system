package com.alisha.projects.music.recommendation.Controllers;

import com.alisha.projects.music.recommendation.Model.PlayListToSongs;
import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Model.SongsPlayList;
import com.alisha.projects.music.recommendation.Request.CreatePlayListRequest;
import com.alisha.projects.music.recommendation.Response.ShowPlayListResponse;
import com.alisha.projects.music.recommendation.Service.PlayListInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayListController {
    @Autowired
    PlayListInfoService playListInfoService;

    @PostMapping("create/playList")
    SongsPlayList createPlayList(@RequestBody CreatePlayListRequest createPlayListRequest){
        return playListInfoService.createPlayList(createPlayListRequest);
    }

    @PostMapping("add/song/to/user/playList")
    PlayListToSongs addSongToUserPlayList(@RequestParam Long userId, @RequestBody Song song, @RequestParam Long playListId){
        return playListInfoService.addSongToUserPlayList(userId,song,playListId);
    }

    @GetMapping("display/playList")
    ShowPlayListResponse displayPlayList(@RequestParam Long userId){
        return playListInfoService.displayPlayListByUser(userId);
    }
}
