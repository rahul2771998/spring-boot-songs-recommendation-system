package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.PlayListToSongs;
import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Model.SongsPlayList;
import com.alisha.projects.music.recommendation.Request.CreatePlayListRequest;
import com.alisha.projects.music.recommendation.Response.ShowPlayListResponse;


public interface PlayListInfoService {
    public SongsPlayList createPlayList(CreatePlayListRequest createPlayListRequest);
    public PlayListToSongs addSongToUserPlayList(Long userId, Song song, Long playListId);
    public ShowPlayListResponse displayPlayList(Long userId);

    ShowPlayListResponse displayPlayListByUser(Long userId);
}
