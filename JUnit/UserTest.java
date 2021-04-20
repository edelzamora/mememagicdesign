import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    //Feed Objetcs
    Feed feed1;
    Feed feed2;
    Feed feed3;
    
    //backgroundImage objects
    BackgroundImage chicken;
    BackgroundImage puppy;
    BackgroundImage kitten;
    BackgroundImage secondKitten;
    
    //User objects
    User bob123;
    User tina;
    User johnTho;
    User emptyUser;
    User tim;
    
    //Meme objects
    Meme funnyChicken;
    Meme sleepyPuppy;
    Meme sleepyKitten;
    Meme sleepyKitten2;
    
    //ArrayLists of Memes
    ArrayList<Meme> emptyMemeList ;
    ArrayList<Meme> nonEmptyMemeList;

    @Before
    public void setUp() {
        //Feed objects
        feed1 = new Feed();
        feed2 = new Feed();
        feed3 = new Feed();
        
      //backgroundImage objects
        chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head");
        puppy = new BackgroundImage("puppy.png", "Sleeping puppy", "Image of a puppy sleeping on their little bed");
        kitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
        secondKitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
        
      //User objects
        bob123 = new User("bob123");
        johnTho = new User("johnTho");
        tina = new User("tina");
        tim = new User("tim");
        emptyUser = new User();
        
      //Meme object
        funnyChicken = new Meme(chicken, "Safety first", bob123);
        sleepyPuppy = new Meme(puppy, "Look at the puppy", johnTho);
        sleepyKitten = new Meme(kitten, "Look at the kitten", tim);
        sleepyKitten2 = new Meme(kitten, "Look at the kitten", tim);
        
       
      //ArrayLists of Memes
        nonEmptyMemeList = new ArrayList<Meme>(Arrays.asList(funnyChicken, sleepyPuppy, sleepyKitten));
        emptyMemeList = new ArrayList<Meme>();
        
        feed1.setMemes(nonEmptyMemeList);
        
    }

    @Test
    public void UserTest() {
        //Constructor no parameters
        User u1 = new User();
        assertEquals(emptyUser, u1);
        
        //Constructor with parameters
        User u2 = new User("tim");
        assertEquals(tim, u2);
    }
    
    @Test
    public void rateMemeTest() {
        tim.rateMeme(funnyChicken, 1);
        assertEquals(1.0, funnyChicken.calculateOverallRating(), 0.01);
    }
    
    @Test
    public void createMemeTest() {
        bob123.createMeme(chicken, "Safety first");
        assertTrue(bob123.getMemesCreated().contains(funnyChicken));
        
        johnTho.createMeme(puppy, "Look at the puppy");
        assertFalse(bob123.getMemesCreated().contains(sleepyPuppy));
    }
    
    @Test
    public void deleteMemeTest() {
        bob123.createMeme(chicken, "Safety first");
        assertTrue(bob123.deleteMeme(funnyChicken));
        
        johnTho.createMeme(puppy, "Look at the puppy");
        assertFalse(bob123.deleteMeme(sleepyPuppy));
    }
    
    @Test
    public void shareMemeTest() {
        
        //feed is empty
        assertTrue(feed2.getMemes().isEmpty());
        
        //Sharing the meme to feed2 which was empty
        bob123.shareMeme(funnyChicken, feed2);
        
        //Testing if contains the meme
        assertTrue(feed2.getMemes().contains(funnyChicken));
        
        //Testing if it is empty
        assertFalse(feed2.getMemes().isEmpty());
    }
    
    @Test
    public void rateNextMemeFromFeedTest() {
        bob123.createMeme(chicken, "Safety first");
        bob123.shareMeme(funnyChicken, feed2);
        assertFalse(bob123.rateNextMemeFromFeed(feed2, 1));
        
        assertFalse(tim.rateNextMemeFromFeed(feed3, 1));
        
        johnTho.shareMeme(sleepyPuppy, feed2);
        assertTrue(johnTho.rateNextMemeFromFeed(feed2, 1));
    }
    
    @Test
    public void calculateReputationTest() {
        bob123.createMeme(chicken, "Safety first");
        bob123.shareMeme(funnyChicken, feed2);
        tim.rateNextMemeFromFeed(feed2, 1);
        johnTho.rateNextMemeFromFeed(feed2, -1);
        
        assertEquals(0.0, tim.calculateReputation(), 0.01);
        assertEquals(0.0, bob123.calculateReputation(), 0.01);
    }
    
    @Test
    public void toStringTest() {
        assertEquals("bob123 has rated (0) memes, (0.0)", bob123.toString());
    }
    
    @Test
    public void equalsTest() {
        User u1 = new User();
        assertTrue(emptyUser.equals(u1));
        
        User u2 = new User("tim");
        assertTrue(tim.equals(u2));
        
        assertFalse(johnTho.equals(bob123));
    }
    
    @Test
    public void setAndGetUserNameTest() {
        assertEquals("No user given", emptyUser.getUserName());
        
        emptyUser.setUserName("zim");
        assertEquals("zim", emptyUser.getUserName());
    }
    
    @Test
    public void setAndGetMemesCreatedTest() {
        assertTrue(bob123.getMemesCreated().isEmpty());
        
        bob123.setMemesCreated(nonEmptyMemeList);
        assertFalse(bob123.getMemesCreated().isEmpty());
        
    }
    
    @Test
    public void setAndGetMemesViewedTest() {
        assertTrue(bob123.getMemesViewed().isEmpty());
        
        bob123.setMemesViewed(nonEmptyMemeList);
        assertFalse(bob123.getMemesViewed().isEmpty());
    }
    
    @Test
    public void compareToTest() {
        User secondTim = new User("tim");
        tim.setMemesCreated(nonEmptyMemeList);
        assertEquals(3, secondTim.compareTo(tim));
        
        secondTim.setMemesCreated(nonEmptyMemeList);
        assertEquals(0, secondTim.compareTo(tim));
        
        assertEquals(-18, bob123.compareTo(tina));
    }

}