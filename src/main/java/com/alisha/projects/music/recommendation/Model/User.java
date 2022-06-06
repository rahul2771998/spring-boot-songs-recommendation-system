package com.alisha.projects.music.recommendation.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long phone;
    @JsonProperty("play_list_id")
    @Column(name="play_list_id")
    private  Long playListId;



}
