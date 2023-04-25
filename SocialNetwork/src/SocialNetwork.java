import enums.PostType;
import enums.SortType;
import models.Comment;
import models.Feed;
import models.User;

import java.util.HashMap;
import java.util.*;

import java.util.Scanner;

public class SocialNetwork {
    private static List<User> users;
    private static HashMap<String,User> mapUser;

    public static void main(String[] args) {

        users=new ArrayList();
        mapUser=new HashMap<>();
        while (true){


        Scanner sc=new Scanner(System.in);
        //sc.nextLine();
        System.out.println("Login or SignUp");
        String s=sc.nextLine();
        String userName="";
        String userPassword="";
        if(s.compareTo("Login")==0){
            System.out.println("Login");
            System.out.println("Enter user name");
            userName=sc.nextLine();
            System.out.println("Enter user password");
            userPassword=sc.nextLine();
            if(SocialNetwork.login(userName,userPassword)!=null){
                    mapUser.get(userName);
            }else{
                System.out.println("Invalid User/Password");
            }
        }else{
            System.out.println("SignUp");
            System.out.println("Enter user name");
            userName=sc.nextLine();
            System.out.println("Enter user password");
            userPassword=sc.nextLine();
            SocialNetwork.signUp(userName,userPassword);
        }

        User currUser=mapUser.get(userName);

        //PostFeed
        System.out.println("Add Feed: Y/N");
        String addFeed=sc.nextLine();
        if(addFeed.equals("Y")){
            System.out.println("What is the titile og feed :");
            String feedName=sc.nextLine();
            Feed newFeed=new Feed(currUser, PostType.IMAGE,feedName);
            currUser.postFeed(newFeed);
        }

        //showMineFeeds
        System.out.println("Show Feeds : Y/N");
        String show=sc.nextLine();
        if(show.equals("Y")){
            SortType sorttype=SortType.COMMENTS;
            currUser.showFeeds(currUser.getFeeds(),sorttype);
        }


        //commentOnPost
        System.out.println("Post a Comment on user post : Y/N");
        String comment=sc.nextLine();
        if(comment.equals("Y")){
            System.out.println("Select the name of user to which you want to reply from following: ");
            for(int i=0;i<users.size();i++){
                System.out.println(users.get(i).getUserName());
            }
            String userToReply=sc.nextLine();
            User friend=users.stream().filter(i->i.getUserName().equals(userToReply)).findFirst().get();
            System.out.println("Select the feed for "+ userToReply +"user to which you want to reply from following: ");
            for(int i=0;i<friend.getFeeds().size();i++){
                System.out.println(friend.getFeeds().get(i).getFeedName());
            }
            String feedToReply=sc.nextLine();
            Feed feed=friend.getFeeds().stream().filter(i->i.getFeedName()==feedToReply).findFirst().get();
            System.out.println("What is the reply : Y/N");
            String reply=sc.nextLine();
            Comment newComment=new Comment(reply);
            currUser.replyToFeed(feed,newComment);


        }

        //followUsers
        System.out.println("Follow User: Y/N");
        String addUser=sc.nextLine();
        if(addUser.equals("Y")){
            System.out.println("Select the name of user from the following: ");
            for(int i=0;i<users.size();i++){
                System.out.println(users.get(i).getUserName());
            }
            String userToFollow=sc.nextLine();
            User friend=users.stream().filter(i->i.getUserName()==userToFollow).findFirst().get();
            currUser.followUser(friend);
        }
        //upvoteDownvote feeds
        System.out.println("upvoteDownvote a feed of user post : Y/N");
        String yes=sc.nextLine();
        if(yes.equals("Y")){
            System.out.println("Select the name of user to which you want to upvoteDownvote from following: ");
            for(int i=0;i<users.size();i++){
                System.out.println(users.get(i).getUserName());
            }
            String userToReply=sc.nextLine();
            User friend=users.stream().filter(i->i.getUserName()==userToReply).findFirst().get();

            System.out.println("Select the feed for "+ userToReply +"user to which you want to reply from following: ");
            for(int i=0;i<friend.getFeeds().size();i++){
                System.out.println(friend.getFeeds().get(i).getFeedName());
            }

            String feedToReply=sc.nextLine();
            Feed feed=friend.getFeeds().stream().filter(i->i.getFeedName()==feedToReply).findFirst().get();
            System.out.println("For upvote pess:Y and downvote press N");
            String res=sc.nextLine();
            if(res.equals("Y")){
                currUser.upvote(feed);
            }else{
                currUser.downvote(feed);
            }
            System.out.println("Repeat again: "+"YES/NO");
            String ans=sc.nextLine();
            if(ans.equals("NO")){
                break;
            }
        }

        }
    }

    public static void signUp(String username, String password) {
        User newUser = new User(username, password);
        mapUser.put(username,newUser);
        users.add(newUser);
    }

    public static User login(String username, String password) {
        User user = mapUser.get(username);
        if (user != null && user.getUserPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
