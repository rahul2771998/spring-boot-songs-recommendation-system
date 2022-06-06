package com.alisha.projects.music.recommendation.Service;


import com.alisha.projects.music.recommendation.Model.*;
import com.alisha.projects.music.recommendation.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongsRecommendationServiceImpl implements SongsRecommendationService {

    @Autowired
    PlayListRepository playListRepository;

    @Autowired
    PlayListToSongRepository playListToSongRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    FollowingRepository followingRepository;
    
    private Integer singerPriorityFactor=3;
    private Integer genrePriorityFactor=2;
    private Integer tempoPriorityFactor=1;

    @Override
    public List<Song> recommendSongs(Long userId) {

        // For User
        SongsPlayList userPlayList=playListRepository.findByUserId(userId);

        List<PlayListToSongs> playListToSongsList = playListToSongRepository.findByPlayListId(userPlayList.getId());

        System.out.println("playListToSongsList:"+ playListToSongsList.toString());
        List<Song> userPlayListSongs=new ArrayList<>();
        for(PlayListToSongs p: playListToSongsList)
        {
            userPlayListSongs.add(songRepository.findById(p.getSongId()).get());
        }

        Set<Long>  userSongIds=new HashSet<>();
        for(Song song : userPlayListSongs)
            userSongIds.add(song.getId());

        // For Friends
        List<Friend> friendList=friendRepository.findByUserId(userId);

        System.out.println("FriendList: "+friendList.toString());
        List<Song> friendsPlayListSong=new ArrayList<>();
        for(Friend f:friendList) {
            SongsPlayList friendPlayList = playListRepository.findByUserId(f.getFriendId());
            List<PlayListToSongs> friendPlayListToSongsList = playListToSongRepository.findByPlayListId(friendPlayList.getId());
            for (PlayListToSongs p : playListToSongsList) {
                friendsPlayListSong.add(songRepository.findById(p.getSongId()).get());
            }
        }

        //following

        List<Following> followingList=followingRepository.findByUserId(userId);
        List<Song> followingPlayListSong=new ArrayList<>();
        for(Following f:followingList) {
            SongsPlayList followingPlayList = playListRepository.findByUserId(f.getFollowingId());
            List<PlayListToSongs> followingPlayListToSongsList = playListToSongRepository.findByPlayListId(followingPlayList.getId());
            for (PlayListToSongs p : playListToSongsList) {
                followingPlayListSong.add(songRepository.findById(p.getSongId()).get());
            }
        }

        // Count the frequency for singer
        Map<String, Integer> singerMap=new HashMap<>();

        for(Song song: userPlayListSongs)
            singerMap.put(song.getSinger(),singerMap.getOrDefault(song.getSinger(),0)+1);
        for(Song song: friendsPlayListSong)
            singerMap.put(song.getSinger(),singerMap.getOrDefault(song.getSinger(),0)+1);

        for(Song song: followingPlayListSong)
            singerMap.put(song.getSinger(),singerMap.getOrDefault(song.getSinger(),0)+1);

        // Count the frequency for genre
        Map<String, Integer> genreMap=new HashMap<>();
        for(Song song: userPlayListSongs)
            genreMap.put(song.getGenre(),genreMap.getOrDefault(song.getGenre(),0)+1);
        for(Song song: friendsPlayListSong)
            genreMap.put(song.getGenre(),genreMap.getOrDefault(song.getGenre(),0)+1);

        for(Song song: followingPlayListSong)
            genreMap.put(song.getGenre(),genreMap.getOrDefault(song.getGenre(),0)+1);

        // Count the frequency for tempo
        Map<String, Integer> tempoMap=new HashMap<>();
        for(Song song: userPlayListSongs)
            tempoMap.put(song.getTempo(),tempoMap.getOrDefault(song.getTempo(),0)+1);
        for(Song song: friendsPlayListSong)
            tempoMap.put(song.getTempo(),tempoMap.getOrDefault(song.getTempo(),0)+1);

        for(Song song: followingPlayListSong)
            tempoMap.put(song.getTempo(),tempoMap.getOrDefault(song.getTempo(),0)+1);
        
        // Fetch all the songs from Database-->  Song table
        List<Song> songList=songRepository.findAll();
        
        List<RecommendedSong> recommendedSongList=new ArrayList<>();
        for(Song song: songList)
        {
            if(userSongIds.contains(song.getId()))
                continue;
            else {
                Integer priority=0;
                if(singerMap.containsKey(song.getSinger()))
                {
                    priority+=singerMap.get(song.getSinger())*singerPriorityFactor;
                }
                if(genreMap.containsKey(song.getGenre()))
                {
                    priority+=genreMap.get(song.getGenre())*genrePriorityFactor;
                }
                if(tempoMap.containsKey(song.getTempo()))
                {
                    priority+=tempoMap.get(song.getTempo())*tempoPriorityFactor;
                }

                RecommendedSong recommendedSong=new RecommendedSong();
                recommendedSong.setSong(song);
                recommendedSong.setPriority(priority);
                recommendedSongList.add(recommendedSong);
            }
            System.out.println("Song "+song.toString());
        }
        Collections.sort(recommendedSongList,RecommendedSong.RecommedSong);
        System.out.println(recommendedSongList.toString());
        List<Song> recommendedSongsToUser=new ArrayList<>();
        for(RecommendedSong recommendedSong: recommendedSongList)
        {
            recommendedSongsToUser.add(recommendedSong.getSong());
        }
        return recommendedSongsToUser;

    }
}

