import java.util.ArrayList;

public class User {
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
     * ArrayList of memes viewed by the user
     **/
    private ArrayList<Meme> memesViewed;

    // Constructors
    public User() {

    }

    // BEHAVIOR (METHOD)

    /**
     * Gives a number to the meme object
     * 
     * @param meme   A Meme object
     * @param rating An int to set set on the Meme
     **/
    public void rateMeme(Meme meme, int rating) {

    }

    /**
     * Creates an instance of a meme for the User
     * 
     * @param image   The background image for the meme
     * @param caption A short message on the image
     * @return Meme Gives a Meme object
     */
    public Meme createMeme(BackgroundImage image, String caption) {
        return null;
    }

    /**
     * Deletes an instance of a meme for the User
     * 
     * @param Meme Takes a meme to be deleted
     * @return boolean REturns if the meme was deleted
     */
    public boolean deleteMeme(Meme meme) {
        return true;
    }

    /**
     * Takes a meme and places it on a feed
     * 
     * @param Meme Takes a meme and places it on a feed
     * @param Feed Where the meme is going to be placed
     */
    public void shareMeme(Meme meme, Feed feed) {

    }

    /**
     * Sets an integer on the meme that is on the feed
     * 
     * @param Feed a collection of memes
     * @param int A integer that is set on a meme from the feed
     */
    public void rateNextMemeFromFeed(Feed feed, int score) {

    }

    /**
     * Calculates the overall score a meme
     * 
     * @return double The overall score of a meme
     */
    public double calculateReputation() {
        return 0.0;
    }

    /**
     * Stringifys an object
     *
     * @return String An object is casted to a string
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Compares two objects
     * 
     * @param Object Any object passed is conpared to another object
     * @return boolean if the two objects are the same
     */
    @Override
    public boolean equals(Object obj) {
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
        return this.memesViewed;
    }
    
    /**
     * Sets a collection of memes to the user
     * 
     * @param ArrayList A list of memes to set on the User object
     */
    public void setMemesViewed(ArrayList<Meme> memeList) {
        this.memesViewed = memeList;
    }
    
} //END class