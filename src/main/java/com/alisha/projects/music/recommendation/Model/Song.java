package com.alisha.projects.music.recommendation.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String singer;
    private String name;
    private String genre, tempo,base;





   
}
