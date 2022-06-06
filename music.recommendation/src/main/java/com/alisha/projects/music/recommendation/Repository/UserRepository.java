package com.alisha.projects.music.recommendation.Repository;

import com.alisha.projects.music.recommendation.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User save(User user);
}
