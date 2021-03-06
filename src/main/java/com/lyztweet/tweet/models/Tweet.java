package com.lyztweet.tweet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "tweet")
public class Tweet implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long tweet_id;

    @Column(name = "content")
    public String content;

    @Column(name = "time_stamp")
    public Timestamp time_stamp;

    @Column(name = "source_tweet_id")
    public long source_tweet_id = -1;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_tweet")
    public List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "liking_user")
    public List<Likes> liking_user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "retweet_user")
    public List<User> retweet_user;

    public Tweet(String content, Timestamp time_stamp, long source_tweet_id) {
        this.content = content;
        this.time_stamp = time_stamp;
        this.source_tweet_id = -1;
    }

    public Tweet() {

    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime_stamp(Timestamp time_stamp) {
        this.time_stamp = time_stamp;
    }

    public void setSource_tweet_id(long source_tweet_id) {
        this.source_tweet_id = source_tweet_id;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setLiking_user(List<Likes> liking_user) {
        this.liking_user = liking_user;
    }

    public void setRetweet_user(List<User> retweet_user) {
        this.retweet_user = retweet_user;
    }

    public long getTweet_id() {
        return tweet_id;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getTime_stamp() {
        return time_stamp;
    }

    public long getSource_tweet_id() {
        return source_tweet_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Likes> getLiking_user() {
        return liking_user;
    }

    public List<User> getRetweet_user() {
        return retweet_user;
    }
}
