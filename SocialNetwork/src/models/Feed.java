package models;

import enums.PostType;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;


public class Feed {
    @Override
    public String toString() {
        return "Feed{" +
                "postType=" + postType +
                ", commetns=" + commetns +
                ", feedDate=" + feedDate +
                ", upVote=" + upVote +
                ", downVote=" + downVote +
                ", feedBy=" + feedBy +
                '}';
    }

    private int feedId;
    private String feedName;

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    private PostType postType;
    private List<Comment> commetns;
    private Date feedDate;
    private int upVote;
    private int downVote;

    private User feedBy;

    public User getFeedBy() {
        return feedBy;
    }

    public Feed(User user, PostType postType, String feedName) {
        this.feedBy=user;
        this.feedName = feedName;
        this.postType = postType;
        this.feedDate = new Date();
        this.upVote = 0;
        this.downVote = 0;
    }

    public Date getDate() {
        return feedDate;
    }

    public int getFeedId() {
        return feedId;
    }

    public PostType getPostType() {
        return postType;
    }

    public List<Comment> getCommetns() {
        return commetns;
    }

    public int getUpVote() {
        return upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setCommetns(List<Comment> commetns) {
        this.commetns = commetns;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }

    public void addComment(Comment comment){
        getCommetns().add(comment);
    }
}
