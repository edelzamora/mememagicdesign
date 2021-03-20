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
        this.username = "No user given";
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new ArrayList<Meme>();
    }
    
    public User(String username) {
        this.username = username;
        this.memesCreated = new ArrayList<Meme>();
        this.memesViewed = new ArrayList<Meme>();
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
    
    public static void main(String[] args) {
        //Creates Users objects
        User johnTho = new User("johnTho");
        User blob = new User("blob");
        User bob123 = new User("bob123");
        User tinaaa = new User("tinaaa");
        User emma123 = new User("emma123");
        User notBob = new User("bob123");
        
        //Creates BackgroundImage objects
        BackgroundImage chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head");
        BackgroundImage puppy = new BackgroundImage("puppy.png", "Sleeping puppy", "Image of a puppy sleeping on their little bed");
        BackgroundImage kitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
        BackgroundImage duck = new BackgroundImage("duck.png", "Duck chasing squirrel", "Image of a duck chasing a squirrel in the park");

        //Creates Meme objects
        Meme funnyChicken = new Meme(chicken, "Safety first", johnTho);
        Meme sleepyPuppy = new Meme(puppy, "Look at the puppy", blob);
        Meme sleepyKitten = new Meme(kitten, "Look at the kitten", tinaaa);
        Meme secondChicken = new Meme(chicken, "Can't get over the chicken", johnTho);
        Meme funnyDuck = new Meme(duck, "RUN squirrel RUN", emma123);
        
        //User creates memes
        johnTho.createMeme(chicken, "Safety first");
        johnTho.createMeme(chicken, "Can't get over the chicken");
        blob.createMeme(puppy, "Look at the puppy");
        tinaaa.createMeme(kitten, "Look at the kitten");
        emma123.createMeme(duck, "RUN squirrel RUN");
        
        //Creating Feed objects
        Feed feed1 = new Feed();
        Feed feed2 = new Feed();
        
        //Feed Object to string
        System.out.println(feed2); //empty nothing is shared
        
        //User's memes get Created
        for(Meme meme: johnTho.getMemesCreated()) System.out.println(meme);
        
        //share meme
        johnTho.shareMeme(funnyChicken, feed2);
        blob.shareMeme(sleepyPuppy, feed2);
        emma123.shareMeme(funnyDuck, feed2);
        
        //Rate meme
        blob.rateMeme(funnyChicken, 1);
        blob.rateNextMemeFromFeed(feed2, 1);
        emma123.rateNextMemeFromFeed(feed2, 1);
        emma123.rateNextMemeFromFeed(feed2, -1);
        
        //User to string and equals
        System.out.println(bob123.toString());
        System.out.println(blob.toString());
        System.out.println(johnTho.toString());
        System.out.println(bob123.equals(notBob)); //Same username
        System.out.println(bob123.equals(blob)); //Not same username
        
        //User reputation
        System.out.println(johnTho.calculateReputation());
        System.out.println(emma123.calculateReputation());
        System.out.println(blob.calculateReputation());
        
        //Delete memes
        System.out.println("Was it deleted: " + johnTho.deleteMeme(secondChicken)); //true
        System.out.println("Was it deleted: " + johnTho.deleteMeme(funnyChicken)); //false 
        
        //User's memes get Created
        for(Meme meme: johnTho.getMemesCreated()) System.out.println(meme);
        for(Meme meme: blob.getMemesCreated()) System.out.println(meme);
        for(Meme meme: emma123.getMemesCreated()) System.out.println(meme);
        
        //Feed Object to string
        System.out.println(feed2); //has shared items
        
        //Users
        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");
        User u5 = new User("u5");
        
        //feed
        Feed f1 = new Feed();
        
        //User creating memes
        u1.createMeme(duck, "c1");
        u1.createMeme(duck, "c2");
        u1.createMeme(duck, "c3");
        u1.createMeme(duck, "c4");
        u1.createMeme(duck, "c5");
        
        
        System.out.println("-------------------------------------------");
        
        //u1 shares
        for(Meme meme: u1.getMemesCreated()) u1.shareMeme(meme, f1);
        
        System.out.println("-------------------------------------------");
        
        u2.rateNextMemeFromFeed(f1, 1);
        u2.rateNextMemeFromFeed(f1, -1);
        u2.rateNextMemeFromFeed(f1, -1);
        u2.rateNextMemeFromFeed(f1, 1);
        u2.rateNextMemeFromFeed(f1, 1);
        
        u3.rateNextMemeFromFeed(f1, 0);
        u3.rateNextMemeFromFeed(f1, -1);
        u3.rateNextMemeFromFeed(f1, -1);
        u3.rateNextMemeFromFeed(f1, 1);
        u3.rateNextMemeFromFeed(f1, 1);
        
        System.out.println(f1.toString());
        
        System.out.println("-------------------------------------------");
        
        for(Meme meme: u1.getMemesCreated()) System.out.println(meme.calculateOverallRating());;
        System.out.println(u1.calculateReputation());
        for(Meme meme: u1.getMemesCreated()) System.out.println(meme);

    } //END MAIN
    
} // END class