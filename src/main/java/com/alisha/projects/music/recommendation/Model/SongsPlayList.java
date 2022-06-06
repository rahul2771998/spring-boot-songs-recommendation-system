package com.alisha.projects.music.recommendation.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "songs_play_list")
public class SongsPlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("play_list_name")
    @Column(name="play_list_name")
    private String playListName;

    @JsonProperty("user_id")
    @Column(name="user_id")
    private Long userId;


}
