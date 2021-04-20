package src;

import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme>{

    @Override
    public int compare(Meme o1, Meme o2) {
        
        int creatorCompare = o1.getCreator().compareTo(o2.getCreator());
        if (creatorCompare != 0) return creatorCompare;
        
        int ratingCompare = (int) (o2.calculateOverallRating() - o1.calculateOverallRating());
        if (ratingCompare != 0) return ratingCompare;
        
        int captionCompare = o1.getCaption().compareTo(o2.getCaption());
        if (captionCompare != 0) return captionCompare;
        
        int bgImageCompare = o1.getBackgroundImage().compareTo(o2.getBackgroundImage());
        if (bgImageCompare != 0) return bgImageCompare;
        
        if(o1.getShared() && o2.getShared() == false) {
            return -1;
        } else if (o1.getShared() == false && o2.getShared()) {
            return 1;
        }
        
        return 0;
    }
}
