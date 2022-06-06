package com.alisha.projects.music.recommendation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PlayListToSongs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JsonProperty("play_list_id")
    @Column(name="play_list_id")
    private Long playListId;

    @JsonProperty("song_id")
    @Column(name="song_id")
    private Long songId;


}
