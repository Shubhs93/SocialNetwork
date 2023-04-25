package models;

import factory.SortFactory;
import enums.SortType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    private List<User> friends=new ArrayList<>();
    private List<Feed> feeds=new ArrayList<>();

    public String getUserPassword() {
        return userPassword;
    }

    public User(String userName, String userPassword) {
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return userName ;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public void postFeed(Feed newFeed){
        this.getFeeds().add(newFeed);
    }

    public void followUser(User newUser){

        getFriends().add(newUser);
    }

    public void replyToFeed(Feed whichFeed, Comment newComment){
        newComment.setCommentedBy(this);
        System.out.println(this.getUserName()+" posted a comment "+ newComment + " on "+ whichFeed.getFeedBy() +"'s feed" );
        whichFeed.getCommetns().add(newComment);
    }
    public void upvote(Feed whichFeed){//upvote feeds
       whichFeed.setUpVote(whichFeed.getUpVote()+1);
    }
    public void upvote( Comment whatComment){
        whatComment.setUpvote(whatComment.getUpvote()+1);
    }
    public void downvote(Feed whichFeed){//upvote feeds
        whichFeed.setUpVote(whichFeed.getUpVote()-1);
    }
    public void downvote( Comment whatComment){
        whatComment.setUpvote(whatComment.getUpvote()-1);
    }

    public List<Feed> showFeeds(List<Feed> feeds, SortType sortType){
        List<Feed> ans=  SortFactory.getSortFactoryMethod(sortType).sort(feeds);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i).getFeedName());

        }
        return ans;
    }
}
