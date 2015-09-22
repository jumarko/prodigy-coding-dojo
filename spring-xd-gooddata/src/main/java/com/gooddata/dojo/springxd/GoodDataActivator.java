package com.gooddata.dojo.springxd;

import static org.apache.commons.lang.Validate.notEmpty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooddata.GoodData;
import com.gooddata.commons.http.FakeCloseableHttpClient;
import com.gooddata.project.Project;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GoodDataActivator {

    private static final int TWEETS_THRESHOLD = 100;

    private final ObjectMapper objectMapper;
    private final GoodData gd;

    private List<Tweet> tweets = new ArrayList<>();

    public GoodDataActivator(String hostname, String username, String password) {
        notEmpty(hostname, "hostname cannot be empty!");
        notEmpty(username, "username cannot be empty!");
        notEmpty(password, "password cannot be empty!");

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        this.objectMapper = objectMapper;

        this.gd = new GoodData(hostname, username, password) {
            @Override
            protected HttpClient createHttpClient(String login, String password, String hostname, int port, String protocol, HttpClientBuilder builder) {
                return new FakeCloseableHttpClient(super.createHttpClient(login, password, hostname, port, protocol,
                        builder));
            }
        };
    }

    public void parseTweet(String tweetJson) {
        notEmpty(tweetJson, "tweet cannot be empty!");

        try {

            final Tweet tweet = objectMapper.readValue(tweetJson, Tweet.class);
            tweets.add(tweet);

            System.out.println("Incoming tweet: count="  + tweets.size());

            if (tweets.size() >= TWEETS_THRESHOLD && tweets.size() % TWEETS_THRESHOLD == 0) {
                System.out.println("tweets count=" + tweets.size() +
                                ". Threshold reached - uploading data to GoodData platform");
                uploadTweetsToGoodData();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cannot deserialize json: " + tweetJson);
        }

    }

    private void uploadTweetsToGoodData() {
        final Project project = gd.getProjectService().getProjectById("sfvaoy8ggwxdvt1gonncd2gvu6jzpyc0");
        gd.getDatasetService().loadDataset(project, "dataset.tweet", getTweetsAsStream());
        System.out.println("Data to GoodData platform uploaded");
    }

    public InputStream getTweetsAsStream() {
        final StringJoiner lineJoiner = new StringJoiner("\n");
        // add csv header
        lineJoiner.add("\"d_tweet_id.nm_id\", \"d_tweet_text.nm_text\", \"d_tweet_source.nm_source\", " +
                "\"d_tweet_userid.nm_userid\" , \"d_tweet_username.nm_username\", \"f_tweet.f_retweetcount\", " +
                "\"f_tweet.f_favouritecount\", \"d_tweet_timestamp_ms.nm_timestamp_ms\", \"d_tweet_createdat.nm_createdat\"");
        for (Tweet tweet : tweets) {
            lineJoiner.add(tweet.asCsvLine());
        }
        return new ByteArrayInputStream(lineJoiner.toString().getBytes(StandardCharsets.UTF_8));
    }
}
