package com.lyztweet.tweet.Repositories;

import com.lyztweet.tweet.models.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface likesRepository extends CrudRepository<Likes, Long> {
    @Query(value = "insert into Likes(liking_user, liked_tweet) value(:user, :tweet)", nativeQuery = true)
    Boolean save(@Param("user") User user, @Param("tweet") Tweet tweet);

    @Query(value = "delete from Likes l where l.liked_tweet = :tweet and l.liking_user = :user")
    Boolean deleteLikes(@Param("user") User user, @Param("tweet") Tweet tweet);

    @Query(value = "select l.liked_tweet from Likes l where l.liking_user = :user")
    List<Tweet> findliked_tweetByUser(@Param("user") User user);

    @Query(value = "select l.liking_user from Likes l where l.liked_tweet = :tweet")
    List<User> findLiking_userByTweet(@Param("tweet") Tweet tweet);
}