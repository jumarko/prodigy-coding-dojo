package com.gooddata.dojo.springxd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tweet {

    private String id;
    // TODO: change to DateTime
    @JsonProperty("created_at")
    private String createdAt;
    private String text;
    private String source;

    private TweetAuthor user;

    @JsonProperty("retweet_count")
    private int retweetCount;
    @JsonProperty("favourite_count")
    private int favouriteCount;
    @JsonProperty("timestamp_ms")
    private long timestampMs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public TweetAuthor getUser() {
        return user;
    }

    public void setUser(TweetAuthor user) {
        this.user = user;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(long timestampMs) {
        this.timestampMs = timestampMs;
    }


    public String asCsvLine() {
        final StringJoiner fieldJoiner = new StringJoiner(",");
        addField(fieldJoiner, id);
        addField(fieldJoiner, text);
        addField(fieldJoiner, source);
        addField(fieldJoiner, user.getId());
        addField(fieldJoiner, user.getName());
        addField(fieldJoiner, retweetCount);
        addField(fieldJoiner, favouriteCount);
        addField(fieldJoiner, timestampMs);
        addField(fieldJoiner, createdAt);
        return fieldJoiner.toString();
    }

    private StringJoiner addField(StringJoiner fieldJoiner, Object fieldValue) {
        return fieldJoiner.add("\""
                + fieldValue.toString().replace("\"", "\"\"")
                + "\"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Tweet tweet = (Tweet) o;
        return Objects.equals(retweetCount, tweet.retweetCount) &&
                Objects.equals(favouriteCount, tweet.favouriteCount) &&
                Objects.equals(timestampMs, tweet.timestampMs) &&
                Objects.equals(id, tweet.id) &&
                Objects.equals(createdAt, tweet.createdAt) &&
                Objects.equals(text, tweet.text) &&
                Objects.equals(source, tweet.source) &&
                Objects.equals(user, tweet.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, text, source, user, retweetCount, favouriteCount, timestampMs);
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", user=" + user +
                ", retweetCount=" + retweetCount +
                ", favouriteCount=" + favouriteCount +
                ", timestampMs=" + timestampMs +
                '}';
    }
}
