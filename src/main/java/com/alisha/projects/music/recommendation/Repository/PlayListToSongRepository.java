package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.PlayListToSongs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayListToSongRepository extends JpaRepository<PlayListToSongs,Long> {
    List<PlayListToSongs> findByPlayListId(Long playListId);
}

