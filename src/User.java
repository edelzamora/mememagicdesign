package src;

import java.util.ArrayList;
import java.util.TreeSet;

public class User implements Comparable<User> {
    // STATES (Variables

    /**
     * Holds the username
     **/
    private String username;

    /**
     * ArrayList of memes created by the user
     */
    private ArrayList<Meme> memesCreated;

    /**
     * Set of memes viewed by the user
     **/
    private TreeSet<Meme> memesViewed;

    // Constructors
    public User() {
        this.username = "No user given";
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new TreeSet<Meme>();
    }
    
    public User(String username) {
        this.username = username;
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new TreeSet<Meme>();
    }

    // BEHAVIOR (METHOD)

    /**
     * Gives a number to the meme object
     * 
     * @param Meme   A Meme object
     * @param int An int to set on the Meme
     **/
    public void rateMeme(Meme meme, int rating) {
        //Adds the rating to the meme object
        meme.addRating(new Rating(this, rating));
        //Adds the meme to the Users arralist of memes viewed
        this.memesViewed.add(meme);
        
        //Updates the score on the memesCreated meme copy.
        ArrayList<Meme> arr = meme.getCreator().getMemesCreated();
        int memeIndx = arr.indexOf(meme);
        if(memeIndx != -1) arr.get(memeIndx).addRating(new Rating(this, rating));
        
    }

    /**
     * Creates an instance of a meme for the User
     * 
     * @param image   The background image for the meme
     * @param caption A short message on the image
     * @return Meme Gives a Meme object
     */
    public Meme createMeme(BackgroundImage image, String caption) {
        Meme meme = new Meme(image, caption, this);
        this.memesCreated.add(meme);
        return meme;
    }

    /**
     * Deletes an instance of a meme for the User
     * 
     * @param Meme Takes a meme to be deleted
     * @return boolean REturns if the meme was deleted
     */
    public boolean deleteMeme(Meme meme) {
        if (this.memesCreated.contains(meme) && meme.getShared() == false) {
            this.memesCreated.remove(meme);
            return true;
        }
        return false;
    }

    /**
     * Takes a meme and places it on a feed
     * 
     * @param Meme Takes a meme and places it on a feed
     * @param Feed Where the meme is going to be placed
     */
    public void shareMeme(Meme meme, Feed feed) {
        ArrayList<Meme> feedArray = feed.getMemes();
        feedArray.add(meme);
        meme.setShared(true);
    }

    /**
     * Sets an integer on the meme that is on the feed
     * 
     * @param Feed a collection of memes
     * @param int A integer that is set on a meme from the feed
     * @return boolean 
     */
    public boolean rateNextMemeFromFeed(Feed feed, int score) {
        //There are 3 copies of the meme. Located in Feed, memesCreated, memesViewed that needs the score updated.
        
        ArrayList<Meme> feedArray = feed.getMemes();
        
        if (feedArray.size() > 0) {
           //Meme not in the user's viewed or created
            Meme meme = feed.getNewMeme(this);
            
            //Check if not null | Method getNewMeme can return a null
            if (meme != null) { 
                //This updates copies from feed and memesviewed
                
                //Sets the user who rated it and what the user rated
                meme.addRating(new Rating(this, score));
                
                //Adds it to the User's viewed
                this.memesViewed.add(meme);
                
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Calculates the overall score of a meme
     * 
     * @return double The overall score of a meme
     */
    public double calculateReputation() {
        
        if (this.memesCreated.size() > 0) {
            double sumMemesCreated = 0.0;
            for(Meme meme: this.memesCreated) {
                sumMemesCreated = sumMemesCreated + meme.calculateOverallRating();
            }
            
            double reputation = (sumMemesCreated / this.memesCreated.size()) / 2;
            
            return Math.floor(reputation * 100.0) / 100.0;
        }
        
        return 0.0;
    }

    /**
     * Stringifys an object
     *
     * @return String An object is casted to a string
     */
    @Override
    public String toString() {
        return this.username + " has rated " + "(" +this.memesViewed.size() + ")" + " memes, " + "(" + calculateReputation() + ")";
    }

    /**
     * Compares two objects
     * 
     * @param Object Any object passed is conpared to another object
     * @return boolean if the two objects are the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        
        if (!(obj instanceof User)) return false;
        
        User other = (User) obj;
        
        if(this.username != other.username) return false;
        
        return true;
    }

    // GETTERS and SETTERS

    /**
     * Gets the username from the User object
     * 
     * @return String The username of a User object
     */
    public String getUserName() {
        return this.username;
    }
    
    /**
     * Sets the username to a User object
     * 
     * @param String A string to set the User
     */
    public void setUserName(String username) {
        this.username = username;
    }
    
    /**
     * Returns the collection of memes created by the user
     * 
     * @return ArrayList A collection of memes created by the User
     */
    public ArrayList<Meme> getMemesCreated() {
        return this.memesCreated;
    }
    
    /**
     * Sets a collection of memes to the User
     * 
     * @param ArrayList the list to set of a user
     */
    public void setMemesCreated(ArrayList<Meme> memeList) {
        this.memesCreated = memeList;
    }
    
    /**
     * Gets a collection of memes that were viewed by the User object
     * 
     * @return ArrayList returns a list of memes viewed by User
     */
    public ArrayList<Meme> getMemesViewed(){
        ArrayList<Meme> memeList = new ArrayList<Meme>();
        for(Meme meme: this.memesViewed) {
            memeList.add(meme);
        }
        return memeList;
    }
    
    /**
     * Sets a collection of memes to the user
     * 
     * @param ArrayList A list of memes to set on the User object
     */
    public void setMemesViewed(ArrayList<Meme> memeList) {
        TreeSet<Meme> memeSet = new TreeSet<Meme>();
        for(Meme meme: memeList) {
            memeSet.add(meme);
        }
        this.memesViewed = memeSet;
    }
    
    @Override
    public int compareTo(User other) {
        
        int usernameCompare = this.username.compareTo(other.username);
        if(usernameCompare != 0) return usernameCompare;
        
        int memeCountCompare = other.memesCreated.size() - this.memesCreated.size();
        if(memeCountCompare != 0) return memeCountCompare;
        
        
        return 0;
    }
} // END class