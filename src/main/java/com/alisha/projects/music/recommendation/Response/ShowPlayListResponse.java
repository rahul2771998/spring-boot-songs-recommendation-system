package com.alisha.projects.music.recommendation.Response;

import com.alisha.projects.music.recommendation.Model.Song;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShowPlayListResponse {

    @JsonProperty("play_list_id")
    private Long playListId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("play_list_name")
    private String playListName;

    @JsonProperty("song_list")
    private List<Song> songList;


}
