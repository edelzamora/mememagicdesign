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
      public Rating(User user, int score) {
          this.user = user;
          
          //Allowed values and sets them
          if(score == 1 || score == 0 || score == -1) {
              this.score = score;
          } else {
              this.score = 0;
          }
      }
      
      public Rating() {
          this.user = new User();
          this.score = 0;
      }
      
      //BEHAVIOR (Methods)
      /**
       * Stringifys an object
       *
       * @return String An object is casted to a string
       */
      @Override
      public String toString() {
          if(this.score == -1) return "Rating was a downvote";
          if(this.score == 0) return "Rating was a pass";
          if(this.score == 1) return "Rating was an upvote";
          return null;
      }
      
      /**
       * Compares two objects
       * 
       * @param Object Any object passed is conpared to another object
       * @return boolean if the two objects are the same
       */
      @Override
      public boolean equals(Object otherObj) {
          //Checks if the onject is empty
          if(otherObj == null) return false;
          
          //Checks if the object is the same object type
          if(!(otherObj instanceof Rating)) return false;
          
          Rating other = (Rating) otherObj;
          
          //Checks the parameters
          if(this.user != other.user) return false;
          if(this.score != other.score) return false;
          
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
      public boolean setScore(int score) {
          //Allowed values for score and sets it to that value
          if(score == 1 || score == 0 || score == -1) {
              this.score = score;
              return true;
          } else {
              return false;
          }
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
      
      public static void main(String[] args) {
          //Testing
          //Creating User objects
          User bob = new User();
          User johnTho = new User();
          User emma123 = new User();
          
          //Creating Rating objects
          Rating r1 = new Rating(bob, 4); // Not allowed
          Rating r2 = new Rating(johnTho, 1); //Allowed
          Rating r3 = new Rating(); 
          r3.setScore(-1000); //Setting to a non allowed value
          r3.setUser(emma123);
          Rating r4 = new Rating(bob, 4);
          
          //Printing to strings and equals 
          System.out.println(r1.toString());
          System.out.println(r2.toString());
          System.out.println(r3.toString());
          
          System.out.println(r1.equals(r4));
          System.out.println(r2.equals(r3));
          
      } //END MAIN
      
  } //END Class