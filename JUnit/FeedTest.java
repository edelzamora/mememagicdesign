package JUnit;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import src.BackgroundImage;
import src.Feed;
import src.Meme;
import src.User;

public class FeedTest {
    //Feed Objetcs
    Feed feed1;
    Feed feed2;
    
    //backgroundImage objects
    BackgroundImage chicken;
    BackgroundImage puppy;
    
    //User objects
    User bob123;
    User tinaaa;
    User johnTho;
    
    //Meme objects
    Meme funnyChicken;
    Meme sleepyPuppy;
    
    //ArrayLists of Memes
    ArrayList<Meme> emptyMemeList ;
    ArrayList<Meme> nonEmptyMemeList;

    @Before
    public void setUp() {
        //Feed objects
        feed1 = new Feed();
        feed2 = new Feed();
        
      //backgroundImage objects
        chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head");
        puppy = new BackgroundImage("puppy.png", "Sleeping puppy", "Image of a puppy sleeping on their little bed");
        
      //User objects
        bob123 = new User("bob123");
        johnTho = new User("johnTho");
        
      //Meme object
        funnyChicken = new Meme(chicken, "Safety first", bob123);
        sleepyPuppy = new Meme(puppy, "Look at the puppy", johnTho);
       
      //ArrayLists of Memes
        nonEmptyMemeList = new ArrayList<Meme>(Arrays.asList(funnyChicken, sleepyPuppy));
        emptyMemeList = new ArrayList<Meme>();
        
        feed1.setMemes(nonEmptyMemeList);
        
        
    }

    @Test
    public void FeedTest() {
        assertFalse(feed1.getMemes().isEmpty());
        
        assertTrue(feed2.getMemes().isEmpty());
    }
    
    @Test
    public void getNewMemeTest() {
        assertEquals(funnyChicken, feed1.getNewMeme(bob123));
        
        assertNull(feed2.getNewMeme(johnTho));
    }
    
    @Test
    public void toStringTest() {
        
        assertEquals("", feed2.toString());
        
        String correctOutput = "Funny chicken <Image of a chicken with a tiny helmet on its head> 'Safety first' 0.0 [+1: 0, -1: 0] - created by bob123" + "\n" + "Sleeping puppy <Image of a puppy sleeping on their little bed> 'Look at the puppy' 0.0 [+1: 0, -1: 0] - created by johnTho" + "\n";
        assertEquals(correctOutput, feed1.toString());
    }
    
    @Test
    public void setAndGetMemesTest() {
        feed2.setMemes(nonEmptyMemeList);
        assertFalse(feed2.getMemes().isEmpty());
    }

}