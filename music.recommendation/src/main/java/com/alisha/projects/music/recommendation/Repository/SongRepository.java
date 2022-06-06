package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findById(Long Id);
    Song findByName(String name);
    Song save(Song song);


}
