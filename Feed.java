import java.util.ArrayList;

public class Feed {
  //STATES (Instance variables)
    /**
     * Holds a list of memes
     * */
    private ArrayList<Meme> memes;
    
    //Constructors
    public Feed() {
        
    }
    
    //BEHAVIOR (Methods)
    /**
     * Gets a meme from a user
     *
     * @return Meme return a Meme from a User
     */
    public Meme getNewMeme(User user) {
        return null;
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
    
    
    //GETTERS and SETTERS
    /**
     * Gets a list of memes
     * 
     * @return ArrayList Returns a list of memes
     * */
    public ArrayList<Meme> getMemes() {
        return this.memes;
    }
    
    /**
     * Sets a list of memes
     * 
     * @param ArrayList a list of memes to set on the feed
     * */
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }
}
