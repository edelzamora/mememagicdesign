import java.util.ArrayList;

public class Feed {
  //STATES (Instance variables)
    /**
     * Holds a list of memes
     * */
    private ArrayList<Meme> memes;
    
    //Constructors
    public Feed() {
        this.memes = new ArrayList<Meme>();
    }
    
    //BEHAVIOR (Methods)
    /**
     * Grabs a meme from the feed and passes it to the User
     *
     * @return Meme returns a Meme from the feed that the User has not seen
     */
    public Meme getNewMeme(User user) {
        ArrayList<Meme> viewedMemes = user.getMemesViewed();
        ArrayList<Meme> createdMemes = user.getMemesCreated();
        for (Meme meme: this.memes) {
            if (viewedMemes.contains(meme) == false && createdMemes.contains(meme) == false) {
                return meme;
            }
        }
        return null;
    }
    
    /**
     * Stringifys an object
     *
     * @return String An object is casted to a string
     */
    @Override
    public String toString() {
        //If feed does not have any meme objects
        if (this.memes.size() == 0) return "";
        
        String result = "";
        for(Meme meme: this.memes) {
            result = result + meme.toString() + "\n";
        }
        
        return result;
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
     * Sets a list of memes to the Feed Object
     * 
     * @param ArrayList a list of memes to set on the feed
     * */
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }
    
} //END CLASS