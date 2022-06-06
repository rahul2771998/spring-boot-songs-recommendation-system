package com.alisha.projects.music.recommendation.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreatePlayListRequest {


    @JsonProperty("play_list_name")
    private String playListName;

    @JsonProperty("user_id")
    private Long userId;

    List<Long> songs=new ArrayList<>();
}
