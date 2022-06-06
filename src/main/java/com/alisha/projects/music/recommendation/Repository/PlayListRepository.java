package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.SongsPlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends JpaRepository<SongsPlayList,Long> {
    SongsPlayList findByPlayListName(String playListName);
    SongsPlayList findByUserId(Long userId);
    SongsPlayList save(SongsPlayList songsPlayList);

}
