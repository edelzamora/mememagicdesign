public class Meme {
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
     public Meme() {
 
     }
 
     // BEHAVIOR (METHOD)
 
     /**
      * Adds a Rating object to the Meme object
      * 
      * @param Rating A Rating object to set on the Meme
      * @return boolean If the Rating was added to the meme or not
      **/
     public boolean addRating(Rating rating) {
         return true;
     }
 
     /**
      * Calculates all the Ratings of the meme
      * 
      * @return double Returns a double for all the Ratings on the meme
      */
     public double calculateOverallRating() {
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
      * @param Object Any object passed is compared to another object
      * @return boolean if the two objects are the same
      */
     @Override
     public boolean equals(Object obj) {
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
     public void setCaptionVerticalAlign(String align) {
         this.captionVerticalAlign = align;
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

 } //END class