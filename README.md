# Tweet_App

## API

### Tweet

#### Tweet

|                    | Method | URL               | Function                   | Return        |
|--------------------|--------|-------------------|----------------------------|---------------|
| Create a new Tweet | POST   | /tweet/           | postTweet()                | Tweet         |
| Retrieve a Tweet   | GET    | /tweet/{tweet_id} | getTweet(long tweet_id)    | List< Tweet > |
| Update a Tweet     | PUT    | /tweet/{tweet_id} | updateTweet(long tweet_id) | Boolean       |
| Delete a Tweet     | DELETE | /tweet/{tweet_id} | deleteTweet(long tweet_id) | Boolean       |

#### Comment

|                   | Method | URL                                    | Function                                      | Return          |
|-------------------|--------|----------------------------------------|-----------------------------------------------|-----------------|
| Make a comment    | POST   | /tweet/{tweet_id}/comment/             | postComment(long tweet_id)                    | Comment         |
| Delete a comment  | DELETE | /tweet/{tweet_id}/comment/{comment_id} | deleteComment(long tweet_id, long comment_id) | Boolean         |
| Get a comment     | GET    | /tweet/{tweet_id}/comment/{comment_id} | getComment(long tweet_id, long comment_id)    | List< Comment > |


#### Retweet

|                                       | Method | URL                           | Function                               | Return       |
|---------------------------------------|--------|-------------------------------|----------------------------------------|--------------|
| Retweet by a user                     | Post   | /user/{id}/retweet/{tweet_id} | user_retweet(long id, long tweet_id)   | Retweet      |
| fetch the user who retweet this tweet | Get    | /tweet/{tweet_id}/retweet_by  | get_retweetby(long tweet_id)           | List< User > |
| delete retweet                        | Delete | /user/{id}/retweet/{tweet_id} | delete_retweet(long id, long tweet_id) | Boolean      |

#### Likes

|                       | Method    | URL                           | Function                         | Return        |
|-----------------------|-----------|-------------------------------|----------------------------------|---------------|
| User like a tweet     | POST      | /user/{id}/like/{tweet_id}    | postLike(long id, long tweet_id) | boolean       |
| User undo like        | DELETE    | /user/{id}/like/{tweet_id}    | undoLike(long id, long tweet_id) | boolean       |
| Tweet liked by a user | GET       | /tweet/{tweet_id}/liking_user | tweet_liking_user(long tweet_id) | List< User >  |
| User who like a tweet | GET       | /user/{id}/liked_tweet        | user_liked_tweet(long id)        | List< Tweet > |

### User

#### User

|         | Method | URL        | Function         | Return       |
|---------|--------|------------|------------------|--------------|
| sign up | POST   | /user/     | Sign_Up()        | User         |
| sign in | GET    | /user/{id} | Sign_In(long ID) | List< User > |

#### Follow

|                 | Method | URL                                               | Function                               | Return       |
|-----------------|--------|---------------------------------------------------|----------------------------------------|--------------|
| follow a user   | POST   | /user/{source_user_id}/following/{target_user_id} | follow_user(long id, long target_id)   | Boolean      |
| unfollow a user | DELETE | /user/{source_user_id}/following/{target_user_id} | unfollow_user(long id, long target_id) | Boolean      |
| check following | Get    | /user/{id}/following                              | fetch_following(long id)               | List< User > |
| Check follower  | GET    | /user/{id}/follower                               | fetch_follower(long id)                | List< User > |

## Entity

### Tweet

| Key | Type            | Column          |
|-----|-----------------|-----------------|
| PK  | long            | tweet_id        |
|     | String          | content         |
|     | Timestamp       | time_line       |
|     | List< Comment > | comments        |
|     | List< Likes >   | liking_user     |
|     | List< Retweet > | retweet_user_id |

### Comment

| Key | Type      | Column           |
|-----|-----------|------------------|
| PK  | long      | comment_id       |
|     | String    | comment_content  |
|     | Timestamp | time_line        |
| FK  | Tweet     | comment_tweet_id |
| FK  | User      | comment_user_id  |

### Retweet

| Key | Type  | Column          |
|-----|-------|-----------------|
| PK  | long  | retweet_id      |
|     | Tweet | retweet_tweetid |
|     | User  | retweeet_userid |

### User

| Key | Type            | Column           |
|-----|-----------------|------------------|
| PK  | long            | id               |
|     | String          | username         |
|     | String          | passwords        |
|     | List< Follow >  | follower         |
|     | List< Comment > | comment          |
|     | List< Likes >   | likes_tweet      |
|     | List< Retweet > | retweet_tweet_id |

### Follow

| Key | Type | Column      |
|-----|------|-------------|
| PK  | long | follow_id   |
| FK  | User | follow_user |
| FK  | User | followed    |
| FK  | User | following   |

### Likes

| Key | Type  | Column      |
|-----|-------|-------------|
| PK  | long  | likes_id    |
| FK  | Tweet | liked_tweet |
| FK  | User  | liking_user |
