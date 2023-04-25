package stratey;

import models.Feed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByComments implements SortNewsFeed{
    @Override
    public List<Feed> sort(List<Feed> feeds) {

        List<Feed> newfeed=new ArrayList<>(feeds);
        Collections.sort(newfeed, new Comparator<Feed>() {
            @Override
            public int compare(Feed o1, Feed o2) {
                int a=o1.getCommetns().size();
                int b=o2.getCommetns().size();
                return b-a;
            }
        });
        return newfeed;
    }
}
