package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepository extends JpaRepository<Following,Long> {
    List<Following>  findByUserId(Long userId);

}
