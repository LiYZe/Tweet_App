package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User new_user);
    List<User> findById(long id);

    @Query(value = "select * from User u where u.id = :id", nativeQuery = true)
    User findtargetUser(@Param("id") long id);
}
