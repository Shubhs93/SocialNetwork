package models;

import java.util.Date;
import java.util.List;

public class Comment {
    private int commentId;
    private User commentedBy;
    private String parentComment;
    private int postId;//feed or comment
    private int upvote;
    private int downvot;
    private List<Comment> commentsOnComment;
    private Date commentDate;

    @Override
    public String toString() {
        return "Comment{" +
                "commentedBy=" + commentedBy +
                ", parentComment='" + parentComment + '\'' +
                ", postId=" + postId +
                ", upvote=" + upvote +
                ", downvot=" + downvot +
                ", commentsOnComment=" + commentsOnComment +
                '}';
    }


    public Comment( String parentComment) {
        this.parentComment = parentComment;
        this.upvote = 0;
        this.downvot = 0;
        this.commentDate=new Date();
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public User getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(User commentedBy) {
        this.commentedBy = commentedBy;
    }

    public String getParentComment() {
        return parentComment;
    }

    public void setParentComment(String parentComment) {
        this.parentComment = parentComment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvot() {
        return downvot;
    }

    public void setDownvot(int downvot) {
        this.downvot = downvot;
    }

    public List<Comment> getCommentsOnComment() {
        return commentsOnComment;
    }

    public void setCommentsOnComment(List<Comment> commentsOnComment) {
        this.commentsOnComment = commentsOnComment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }
}
