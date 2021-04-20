package src;

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
          this.score = validateScore(score);
      }
      
      public Rating() {
          this.user = new User();
          this.score = 0;
      }
      
      //Helper Methods
      /**
       * Validates if the score passed is inclusive within -1 to 1 range
       * 
       * @param int the score it is checking
       * @return int returns the score if within the range if not defaults to 0
       */
      private int validateScore(int score) {
        //Allowed values and returns them
          if(score == 1 || score == 0 || score == -1) {
              return score;
          } else {
              return 0;
          }
      }
      
      //BEHAVIOR (Methods)
      /**
       * Stringifys an object
       *
       * @return String An object is casted to a string
       */
      @Override
      public String toString() {
          if(this.score == -1) return this.user.getUserName() + " rated as a downvote";
          if(this.score == 0) return this.user.getUserName() + " rated as a pass";
          if(this.score == 1) return this.user.getUserName() + " rated as an upvote";
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
       * @return boolean if setting the score was successful or not
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
          User bob = new User("bob");
          User johnTho = new User("johnTho");
          User emma123 = new User("emma123");
          
          //Creating Rating objects
          Rating r1 = new Rating(bob, 4); // Not allowed
          Rating r2 = new Rating(johnTho, 1); //Allowed
          Rating r3 = new Rating(emma123, -1000); //not allowed value
          Rating r4 = new Rating(bob, 4);
          
          //Printing to strings and equals 
          System.out.println(r1.toString());
          System.out.println(r2.toString());
          System.out.println(r3.toString());
          System.out.println("-------------------------------------------");
          System.out.println(r1.equals(r4));
          System.out.println(r2.equals(r3));
          System.out.println("-------------------------------------------");
          System.out.println(r1.getUser().getUserName());
      } //END MAIN
      
  } //END Class