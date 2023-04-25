package stratey;

import models.Feed;

import java.util.*;

public class SortByTimeStamp implements SortNewsFeed{
    @Override
    public List<Feed> sort(List<Feed> feeds) {

        List<Feed> newfeed=new ArrayList<>(feeds);
        Collections.sort(newfeed, new Comparator<Feed>() {
            @Override
            public int compare(Feed o1, Feed o2) {
               return o1.getDate().compareTo(o2.getDate());
            }
        });
        return newfeed;
    }
}
