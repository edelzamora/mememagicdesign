import java.util.ArrayList;
import java.util.Arrays;

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
      
      public static void main(String[] args) {
          //TESTING
          
          //Creating background image objects
          BackgroundImage chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head");
          BackgroundImage kitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
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
          
          //Creating Feed objects
          Feed feed1 = new Feed();
          Feed feed2 = new Feed();
          
          //Creating an array to pass to the Feed object
          ArrayList<Meme> randomMemeList = new ArrayList<Meme>(Arrays.asList(funnyChicken, sleepyPuppy, sleepyKitten, secondChicken)); // Used this resource https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/ to help with this line of code
          ArrayList<Meme> randomMemes = new ArrayList<Meme>();
          
          //setting a arrays to the feed
          feed1.setMemes(randomMemeList); //non empty array
          feed2.setMemes(randomMemes); //empty array
          
          //Printing the feed with the to string
          System.out.println(feed1.toString());
          System.out.println(feed2.toString());
          johnTho.rateMeme(feed1.getNewMeme(johnTho), 1);
          System.out.println(feed1.getNewMeme(johnTho));
          System.out.println(feed1.getMemes().contains(null));
      } //END MAIN
      
  } //END CLASS
