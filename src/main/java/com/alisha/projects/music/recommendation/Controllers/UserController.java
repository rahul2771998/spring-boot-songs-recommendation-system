package com.alisha.projects.music.recommendation.Controllers;

import com.alisha.projects.music.recommendation.Model.Following;
import com.alisha.projects.music.recommendation.Model.Friend;
import com.alisha.projects.music.recommendation.Model.User;
import com.alisha.projects.music.recommendation.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController   // this is used because it's restAPI we have built
public class UserController {
    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/add/user")       // this path is given url vala (http://localhost:8080/add/user)
    User registerUser(@RequestBody User user){  // ye client(postman) se JSON data utha kr user class Object me convert kr dega
        System.out.println("User: "+user.toString());
        return userInfoService.addUser(user);
    }

    @PostMapping("/add/friend")
    Friend addFriend(@RequestParam ("userId1") Long userId1, @RequestParam ("userId2") Long userId2){
        System.out.println("userId1: "+userId1 +" userId2:"+userId2);
        return userInfoService.userAddFriend(userId1, userId2);
    }

    @PostMapping("/user/follow")//http://localhost:8081/user/registration?userId1=123&userId2=23452
    Following addFollower(@RequestParam ("userId1") Long userId1, @RequestParam ("userId2") Long userId2){
        return userInfoService.followUser(userId1, userId2);
    }

    @GetMapping("/get/user/{userId}") // (http://localhost:8080/get/user/123)
    User getUserProfile(@PathVariable Long userId ){  // jo bhi variable pass krna he vo direct path ke sath krlo, that is why we are using pathVariable
        return userInfoService.getUserProfile(userId);

    }

    @DeleteMapping("/delete")
    User deleteUser(@RequestBody User user){
        return userInfoService.deleteUser(user);
    }

}
