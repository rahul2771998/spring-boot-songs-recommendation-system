package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long> {
    List<Friend> findByUserId(Long userId);
    List<Friend> findByFriendId(Long friendId);
    Friend save(Friend friend);

}
