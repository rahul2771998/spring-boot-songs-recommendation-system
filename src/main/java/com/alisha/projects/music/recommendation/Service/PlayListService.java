package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.PlayListToSongs;
import com.alisha.projects.music.recommendation.Model.Song;
import com.alisha.projects.music.recommendation.Model.SongsPlayList;
import com.alisha.projects.music.recommendation.Repository.PlayListRepository;
import com.alisha.projects.music.recommendation.Repository.PlayListToSongRepository;
import com.alisha.projects.music.recommendation.Repository.SongRepository;
import com.alisha.projects.music.recommendation.Request.CreatePlayListRequest;
import com.alisha.projects.music.recommendation.Response.ShowPlayListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayListService implements PlayListInfoService {

    @Autowired
    PlayListRepository playListRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    PlayListToSongRepository playListToSongRepository;

    @Override
    public SongsPlayList createPlayList(CreatePlayListRequest createPlayListRequest) {
        SongsPlayList songsPlayList=new SongsPlayList();
        songsPlayList.setPlayListName(createPlayListRequest.getPlayListName());
        songsPlayList.setUserId(createPlayListRequest.getUserId());
        playListRepository.save(songsPlayList);


        for(Long songId: createPlayListRequest.getSongs())
        {
            PlayListToSongs playListToSongs=new PlayListToSongs();
            playListToSongs.setSongId(songId);
            playListToSongs.setPlayListId(songsPlayList.getId());
            playListToSongRepository.save(playListToSongs);
        }
        return songsPlayList;
    }

    @Override
    public PlayListToSongs addSongToUserPlayList(Long userId, Song song, Long playListId) {
        PlayListToSongs playListToSongs=new PlayListToSongs();
        playListToSongs.setPlayListId(playListId);
        playListToSongs.setSongId(song.getId());
        return playListToSongRepository.save(playListToSongs);
    }

    @Override
    public ShowPlayListResponse displayPlayList(Long playListId) {
        List<PlayListToSongs> playListToSongsList= playListToSongRepository.findByPlayListId(playListId);
        SongsPlayList songsPlayList=playListRepository.findById(playListId).get();
        ShowPlayListResponse showPlayListResponse=new ShowPlayListResponse();
        showPlayListResponse.setPlayListId(playListId);
        showPlayListResponse.setPlayListName(songsPlayList.getPlayListName());
        showPlayListResponse.setUserId(songsPlayList.getUserId());
        List<Song> l=new ArrayList<>();
        for(PlayListToSongs p: playListToSongsList)
        {
            Song song=songRepository.findById(p.getSongId()).get();
            l.add(song);

        }
        showPlayListResponse.setSongList(l);
        return showPlayListResponse;
    }

    @Override
    public ShowPlayListResponse displayPlayListByUser(Long userId) {

        SongsPlayList songsPlayList=playListRepository.findByUserId(userId);
        List<PlayListToSongs> playListToSongsList=playListToSongRepository.findByPlayListId(songsPlayList.getId());
        ShowPlayListResponse showPlayListResponse=new ShowPlayListResponse();
        showPlayListResponse.setPlayListId(songsPlayList.getId());
        showPlayListResponse.setPlayListName(songsPlayList.getPlayListName());
        showPlayListResponse.setUserId(songsPlayList.getUserId());
        List<Song> l=new ArrayList<>();
        for(PlayListToSongs p: playListToSongsList)
        {
            Song song=songRepository.findById(p.getSongId()).get();
            l.add(song);

        }
        showPlayListResponse.setSongList(l);
        return showPlayListResponse;
    }
}
