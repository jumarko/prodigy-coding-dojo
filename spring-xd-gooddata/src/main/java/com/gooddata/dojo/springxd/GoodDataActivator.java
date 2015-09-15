package com.gooddata.dojo.springxd;

import static org.apache.commons.lang.Validate.notEmpty;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

import java.io.IOException;

public class GoodDataActivator {

    private final ObjectMapper objectMapper;

    public GoodDataActivator() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getFactory().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        this.objectMapper = objectMapper;
    }

    public Tweet parseTweet(String tweetJson) {
        notEmpty(tweetJson, "tweet cannot be empty!");

        try {
            System.out.println("Parsing tweet json: " + tweetJson);
            final Tweet tweet = objectMapper.readValue(tweetJson, Tweet.class);
            System.out.println("Parsed tweet:\n" + tweet);
            return tweet;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cannot deserialize json: " + tweetJson);
        }

    }
}
