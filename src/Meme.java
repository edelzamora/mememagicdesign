package src;

public class Meme implements Comparable<Meme> {
    // STATES (Variables
   
       /**
        * Holds the User
        **/
       private User creator;
   
       /**
        * Holds the BackgroundImage object
        */
       private BackgroundImage backgroundImage;
   
       /**
        * Holds an array of Rating objects
        **/
       private Rating[] ratings;
       
       /**
        * Holds the caption to the image
        **/
       private String caption;
       
       /**
        * Holds the alignment foe the caption
        **/
       private String captionVerticalAlign;
       
       /**
        * If the Meme was shared or not
        **/
       private boolean shared;
   
       // Constructors
       public Meme(BackgroundImage bgImage, String caption, User creator) {
           this.backgroundImage = bgImage;
           this.caption = caption;
           this.creator = creator;
           this.ratings = new Rating[10];
           this.captionVerticalAlign = "bottom";
       }
       
       public Meme() {
           this.backgroundImage = new BackgroundImage();
           this.caption = "No caption given";
           this.creator = new User();
           this.ratings = new Rating[10];
           this.captionVerticalAlign = "bottom"; 
       }
   
       // BEHAVIOR (METHOD)
   
       /**
        * Adds a Rating object to the Meme object
        * 
        * @param Rating A Rating object to set on the Meme
        * @return boolean If the Rating was added to the meme or not
        **/
       public boolean addRating(Rating ratingObj) {
           Rating[] ratingArray = this.ratings;
           
          //Check if there are empty slots
           for(int i = 0; i < ratingArray.length; i++) {
               if(ratingArray[i] == null) { 
                   ratingArray[i] = ratingObj;
                   return true;
               } 
           }
            //There is no slots
            //Shift everything by one and add the raitng onject to the end of the array
           for(int j = 0; j < ratingArray.length - 1; j++) {
               ratingArray[j] = ratingArray[j + 1];
           }
           ratingArray[9] = ratingObj;
           return true;
       }
   
       /**
        * Calculates all the Ratings of the meme
        * 
        * @return double Returns a double for all the Ratings on the meme
        */
       public double calculateOverallRating() {
           Rating[] ratingArray = this.ratings;
           double sum = 0.0;
           for(int i = 0; i < ratingArray.length; i++) {
               if (ratingArray[i] != null) { // Making sure it has a rating
                   sum = sum + ratingArray[i].getScore();
               } else {
                   sum = sum + 0.0;
               }
           }
           return sum;
       }
       
       // HELPER METHODS
       
       /**
        * Counts all the positive ones from the array ratings
        * 
        * @return int The number of positive ones
        */
       private int getPostiveOnes() {
           Rating[] ratingArray = this.ratings;
           int posOneCount = 0;
           for(int i = 0; i < ratingArray.length; i++) {
               if (ratingArray[i] != null) {
                   if(ratingArray[i].getScore() == 1) posOneCount++;   
               }
           }
           return posOneCount;
       }
       
       /**
        * Counts all the negative ones from the array ratings
        * 
        * @return int The number of negative ones
        */
       private int getNegativeOnes() {
           Rating[] ratingArray = this.ratings;
           int negOneCount = 0;
           for(int i = 0; i < ratingArray.length; i++) {
               if(ratingArray[i] != null) {
                   if(ratingArray[i].getScore() == -1) negOneCount++;
               }
           }
           return negOneCount;
       }
   
   
       /**
        * Stringifys an object
        *
        * @return String An object is casted to a string
        */
       @Override
       public String toString() {
           return this.backgroundImage + " '" + this.caption + "' " + calculateOverallRating() + " [+1: " + getPostiveOnes() + ", -1: " + getNegativeOnes() + "]" + " - created by " + this.creator.getUserName();
       }
   
       /**
        * Compares two objects
        * 
        * @param Object Any object passed is compared to another object
        * @return boolean if the two objects are the same
        */
       @Override
       public boolean equals(Object otherObj) {
           //Checks if the onject is empty
           if(otherObj == null) return false;
           
           //Checks if the object is the same object type
           if(!(otherObj instanceof Meme)) return false;
           
           Meme other = (Meme) otherObj;
           
           //Checks the parameters
           if(this.creator != other.creator) return false;
           if(this.caption != other.caption) return false;
           if(this.backgroundImage != other.backgroundImage) return false;
           
           return true;
       }
   
       // GETTERS and SETTERS
   
       /**
        * Gets the User object
        * 
        * @return User A User object from the Meme object
        */
       public User getCreator() {
           return this.creator;
       }
       
       /**
        * Sets the User object to the Meme object
        * 
        * @param User A User to set on the Meme
        */
       public void setCreator(User creator) {
           this.creator = creator;
       }
       
       /**
        * Returns the backgroundImage of the Meme obj
        * 
        * @return BackgroundImage The background image of a Meme obj
        */
       public BackgroundImage getBackgroundImage() {
           return this.backgroundImage;
       }
       
       /**
        * Sets a background image to the Meme obj
        * 
        * @param BackgroundImage The image to set as the background on the Meme obj
        */
       public void setBackgroundImage(BackgroundImage image) {
           this.backgroundImage = image;
       }
       
       /**
        * Gets the array of Rating obj from the Meme obj
        * 
        * @return Rating[] The array of ratings from Meme
        */
       public Rating[] getRatings(){
           return this.ratings;
       }
       
       /**
        * Sets the Rating to the Meme obj
        * 
        * @param Rating The Ratings to set on the Meme obj
        */
       public void setRatings(Rating[] ratings) {
           this.ratings = ratings;
       }
       
       /**
        * Gets the caption of the Meme obj
        * 
        * @return String Returns the caption of the Meme
        */
       public String getCaption(){
           return this.caption;
       }
       
       /**
        * Sets a caption of the Meme obj
        * 
        * @param String Takes a caption to set on the Meme obj
        */
       public void setCaption(String caption) {
           this.caption = caption;
       }
       
       /**
        * Gets the caption vertical align from the Meme obj
        * 
        * @return String Returns the caption vertical align
        */
       public String getCaptionVerticalAlign(){
           return this.captionVerticalAlign;
       }
       
       /**
        * Sets the caption vertical align on the Meme obj
        * 
        * @param String Where to align the caption vertically
        */
       public boolean setCaptionVerticalAlign(String align) {
           //Allowed allgments
           boolean top = align.equals("top");
           boolean mid = align.equals("middle");
           boolean bottom = align.equals("bottom");
           
           if(top || mid || bottom) { //Checks if allowed and sets it
               this.captionVerticalAlign = align;
               return true;
           }
           
           return false;
       }
       
       /**
        * Gets the status of the meme being shared
        * 
        * @return boolean If the Meme was shared or not
        */
       public boolean getShared(){
           return this.shared;
       }
       
       /**
        * Sets a status on the meme being shared
        * 
        * @param boolean If the meme is shared or not
        */
       public void setShared(boolean shared) {
           this.shared = shared;
       }
       
       //CompareTO method
       @Override
       public int compareTo(Meme other) {
           
           int captionCompare = this.caption.compareTo(other.caption);
           if(captionCompare != 0) return captionCompare;
           
           int bgImageCompare = this.backgroundImage.compareTo(other.backgroundImage);
           if(bgImageCompare != 0) return bgImageCompare;
           
           int ratingCompare = (int) (other.calculateOverallRating() - this.calculateOverallRating());
           if(ratingCompare != 0) return ratingCompare;
           
           if(this.shared && other.shared == false) {
               return -1;
           } else if (this.shared == false && other.shared) {
               return 1;
           }
           
           return 0;
       }
       
       public static void main(String[] args) {
           //TESTING
           
           //Creating background image objects
           BackgroundImage chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head"); //Given params
           BackgroundImage kitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed"); //Empty || No params
           BackgroundImage puppy = new BackgroundImage("puppy.png", "Sleeping puppy", "Image of a puppy sleeping on their little bed");
           BackgroundImage duck = new BackgroundImage("duck.png", "Duck chasing squirrel", "Image of a duck chasing a squirrel in the park");
           
           //Creating user objects
           User bob123 = new User("bob123");
           User tinaaa = new User("tinaaa");
           User johnTho = new User("johnTho");
           
           //Creating meme objects
           Meme funnyChicken = new Meme(chicken, "Safety first", bob123);
           Meme sleepyPuppy = new Meme(puppy, "Look at the puppy", tinaaa);
           Meme sleepyKitten = new Meme(kitten, "Look at the kitten", johnTho);
           Meme secondChicken = new Meme(chicken, "Safety first", bob123);
           Meme funnyDuck = new Meme(duck, "RUN squirrel RUN", johnTho);
           
           // Creating rating objects 
           Rating tinaRating = new Rating(tinaaa, 1);
           Rating bobRating = new Rating(bob123, -1);
           Rating tinaTwoRating = new Rating(tinaaa, 1);
           Rating johnRating = new Rating(johnTho, 5);//Not in the allowed values 
           
           //Changing alignments
           System.out.println("-------------------------------------------");
           System.out.println(sleepyPuppy.getCaptionVerticalAlign()); //Getting alignment
           
           System.out.println(funnyDuck.getCaptionVerticalAlign());
           System.out.println(funnyDuck.setCaptionVerticalAlign("top")); //Passing an allowed position
           System.out.println(funnyDuck.getCaptionVerticalAlign());
           
           System.out.println(sleepyKitten.getCaptionVerticalAlign());
           System.out.println(sleepyKitten.setCaptionVerticalAlign("left")); //Passing not allowed position
           System.out.println(sleepyKitten.getCaptionVerticalAlign());
           
           
           //PRINTING
           // to string and equals for Meme objects
           System.out.println("-------------------------------------------");
           
           System.out.println(funnyChicken.toString());
           System.out.println(sleepyPuppy.toString());
           System.out.println(sleepyKitten.toString());
           System.out.println(secondChicken.toString());
           
           System.out.println(funnyChicken.equals(sleepyPuppy));
           System.out.println(funnyChicken.equals(secondChicken));
           System.out.println(sleepyKitten.equals(funnyDuck));
           
           //To string for the rating object
           System.out.println("-------------------------------------------");
           System.out.println("To string: '" + johnRating.toString() + "' and Score: " + johnRating.getScore());
           System.out.println("To string: '" + tinaTwoRating.toString() + "' and Score: " + tinaTwoRating.getScore());
           System.out.println("-------------------------------------------");
           
           //Add rating and calculating overall score
           for(Rating value : funnyChicken.getRatings()) System.out.println(value);
           System.out.println("-------------------------------------------");
           funnyChicken.addRating(johnRating); //Pushed out of array
           funnyChicken.addRating(johnRating); //Pushed out of array
           funnyChicken.addRating(tinaRating); //1th in array
           funnyChicken.addRating(tinaRating); //2th in array
           funnyChicken.addRating(tinaRating); //3th in array
           funnyChicken.addRating(tinaRating); //4th in array
           funnyChicken.addRating(tinaRating); //5th in array
           funnyChicken.addRating(tinaRating); //6th in array
           funnyChicken.addRating(tinaRating); //6th in array
           funnyChicken.addRating(tinaRating); //7th in array
           funnyChicken.addRating(bobRating);  //8th in array
           funnyChicken.addRating(tinaRating); //9th in array
           funnyChicken.addRating(tinaRating); //10th in array
           for(Rating value : funnyChicken.getRatings()) System.out.println(value);
           System.out.println("-------------------------------------------");
           
           
           System.out.println(funnyChicken.toString());
           System.out.println(funnyChicken.calculateOverallRating());
           
           
       } //END MAIN
       
   } //END CLASS
   