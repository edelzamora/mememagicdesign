
public class Rating {
  //STATES (Instance variables)
    /**
     * Holds the score
     * */
    private int score;
    
    /**
     * Holds the user
     * */
    private User user;
    
    //Constructors
    public Rating() {
        
    }
    
    //BEHAVIOR (Methods)
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
    
    //GETTERS and SETTERS
    /**
     * Gets the score
     * 
     * @return int The number that is stored for store
     * */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Sets the score to rating Object
     * 
     * @param int a number to set on the object
     * */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Gets the User object of the rating
     * 
     * @return User The user for the rating
     * */
    public User getUser() {
        return this.user;
    }
    
    /**
     * Sets a user Object on the rating
     * 
     * @param User The user is set to a rating
     * */
    public void setUser(User user) {
        this.user = user;
    }
    
} //END class
