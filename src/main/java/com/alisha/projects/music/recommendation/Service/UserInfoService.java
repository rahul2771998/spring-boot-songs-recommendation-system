package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.Following;
import com.alisha.projects.music.recommendation.Model.Friend;
import com.alisha.projects.music.recommendation.Model.User;


public interface UserInfoService {
    public User addUser(User user);
    public Friend userAddFriend(Long user1Id, Long user2Id);
    public Following followUser(Long user1Id, Long user2Id);
    public User getUserProfile(Long userId);
    public User deleteUser(User user);
}
