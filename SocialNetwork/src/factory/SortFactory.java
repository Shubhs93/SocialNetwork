package factory;

import stratey.*;
import enums.SortType;

public class SortFactory {
    public static SortNewsFeed getSortFactoryMethod(SortType sortType){

        if(sortType.equals("SCORE")){
             return new SortByScore();
        }else if(sortType.equals("COMMENTS")) {
            return new SortByComments();
        }else if(sortType.equals("TIMESTAMP")){
            return new SortByTimeStamp();
        }else{
            return  new SortByFollowers();
        }
    }


}
