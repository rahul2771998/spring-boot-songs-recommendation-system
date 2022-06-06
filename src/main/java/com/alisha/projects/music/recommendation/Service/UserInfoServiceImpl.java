package com.alisha.projects.music.recommendation.Service;

import com.alisha.projects.music.recommendation.Model.Following;
import com.alisha.projects.music.recommendation.Model.Friend;
import com.alisha.projects.music.recommendation.Model.User;
import com.alisha.projects.music.recommendation.Repository.FollowingRepository;
import com.alisha.projects.music.recommendation.Repository.FriendRepository;
import com.alisha.projects.music.recommendation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Controller ko Service se autowire krte he and Service ko Repository se
// Controller service se bat krta he and service repo se
// after autowiring hum userRepository ke sare methods ko call kr skti hoon from this service


@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired    // yha par humne autowire kiya he user ki repo se so that I can save data in repo and delete data from repo
    UserRepository userRepository;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    FollowingRepository followingRepository;

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Friend userAddFriend(Long userId, Long friendId) {
        Friend friend=new Friend();
        friend.setUserId(userId);
        friend.setFriendId(friendId);
        friendRepository.save(friend);
        Friend friend1=new Friend();
        friend1.setUserId(friendId);
        friend1.setFriendId(userId);
        friendRepository.save(friend1);
        return friend;
    }

    @Override
    public Following followUser(Long userId, Long followingId) {
       Following following=new Following();
       following.setUserId(userId);
       following.setFollowingId((followingId));
       return followingRepository.save(following);
    }

    @Override
    public User getUserProfile(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User deleteUser(User user) {
        userRepository.delete(user);
        return user;
    }
}
