package com.gooddata.dojo.springxd;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class TweetTest {

    @Test
    public void asCsvLine() {
        final Tweet tweet = new Tweet();
        tweet.setId("myTweet1");
        tweet.setText("I\"m so excited");
        tweet.setSource("tweet source");
        final TweetAuthor tweetAuthor = new TweetAuthor();
        tweetAuthor.setId("authorId");
        tweetAuthor.setName("author name");
        tweet.setUser(tweetAuthor);
        tweet.setRetweetCount(25);
        tweet.setFavouriteCount(10);
        tweet.setTimestampMs(123445382L);
        tweet.setCreatedAt("Tue Sep 22 06:16:41 +0000 2015");

        assertThat(tweet.asCsvLine(),
                Is.is("\"myTweet1\"," +
                        "\"I\"\"m so excited\"," +
                        "\"tweet source\"," +
                        "\"authorId\"," +
                        "\"author name\"," +
                        "\"25\"," +
                        "\"10\"," +
                        "\"123445382\"," +
                        "\"Tue Sep 22 06:16:41 +0000 2015\""));
    }
}