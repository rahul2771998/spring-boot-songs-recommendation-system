package com.alisha.projects.music.recommendation.Model;

import lombok.Data;

import java.util.Comparator;


// this class is different from other classes I have used entity in other Methos classes because I want to create table for them.
@Data
public  class RecommendedSong {
     private Song song;
     private Integer priority;


    public static Comparator<RecommendedSong> RecommedSong = new Comparator<RecommendedSong>() {

        public int compare(RecommendedSong s1, RecommendedSong s2)
        {
            return s2.getPriority()- s1.getPriority();

        }
    };
}
