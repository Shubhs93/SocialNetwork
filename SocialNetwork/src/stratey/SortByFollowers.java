package stratey;

import models.Feed;

import java.util.List;

public class SortByFollowers implements SortNewsFeed{
    @Override
    public List<Feed> sort(List<Feed> feeds) {
        return feeds;
    }
}
