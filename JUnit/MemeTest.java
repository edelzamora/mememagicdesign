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

public class MemeTest {
    
    //backgroundImage objects
    BackgroundImage chicken;
    BackgroundImage puppy;
    
    //User objects
    User bob123;
    User tina;
    User johnTho;
    User guest;
    
    //Meme objects
    Meme funnyChicken;
    Meme sleepyPuppy;
    Meme secondChicken;
    
    //Rating objects
    Rating bobRating;
    Rating tinaRating;
    Rating johnRating;
    
    //Array of users
    ArrayList<User> userList;
    

    @Before
    public void setUp() {
        //backgroundImage objects
        chicken = new BackgroundImage("chicken.png", "Funny chicken", "Image of a chicken with a tiny helmet on its head");
        puppy = new BackgroundImage("puppy.png", "Sleeping puppy", "Image of a puppy sleeping on their little bed");
        
        //User objects
        bob123 = new User("bob123");
        johnTho = new User("johnTho");
        tina = new User("tina");
        guest = new User("guest");
        
        //Meme object
        funnyChicken = new Meme(chicken, "Safety first", bob123);
        sleepyPuppy = new Meme(puppy, "Look at the puppy", johnTho);
        secondChicken = new Meme(chicken, "Safety first", bob123);
        
        //Rating tinaRating = new Rating(tinaaa, 1);
        bobRating = new Rating(bob123, 5);
        tinaRating = new Rating(tina, 1);
        johnRating = new Rating(johnTho, 1);
        
        userList = new ArrayList<User>(Arrays.asList(bob123, tina, johnTho));
        for(User user: userList) sleepyPuppy.addRating(new Rating(user, 1));
        sleepyPuppy.addRating(new Rating(guest, -1));
    }

    @Test
    public void MemeTest() {
        //Testing default constructor
        Meme emptyMeme = new Meme();
        assertEquals("No user given", emptyMeme.getCreator().getUserName());
        assertEquals("bottom", emptyMeme.getCaptionVerticalAlign());
    }
    
    @Test
    public void addRatingTest() {
        
        //Comparting to rating objects
        Rating correctRating = new Rating(johnTho, 1);
        
        assertEquals(correctRating, johnRating);
        
        //Testing if the array in the Meme object has nulls and if it doesn't it is shifting
        int count = 0;
        int arrCount = 0;
        while (count <= 12) {
            funnyChicken.addRating(new Rating(userList.get(arrCount), 1));
            if (arrCount == 2) arrCount = 0;
            
            count ++;
            arrCount ++;
        }
        
        assertEquals(correctRating, (funnyChicken.getRatings()[9]));
    }
    
    @Test
    public void calculateOverallRatingTest() {
        //Giving the chicken meme 3 scores and getting the overall score
        for(User user: userList) funnyChicken.addRating(new Rating(user, 1));
        double memeScore = funnyChicken.calculateOverallRating();
        assertEquals(3.0, memeScore, 0.01);
        
        //Testing the puppy Meme score
        assertEquals(2.0 ,sleepyPuppy.calculateOverallRating(), 0.01);
    }
    
    @Test
    public void getPostiveOnesTest() {
        //Getting the postive ones from a meme
        assertEquals(3.0, sleepyPuppy.getPostiveOnes(), 0.01);
    }
    
    @Test
    public void getNegativeOnesTest() {
        //Getting the negatives ones from a meme
        assertEquals(1.0, sleepyPuppy.getNegativeOnes(), 0.01);
    }
    
    @Test
    public void toStringTest() {
        String correctStr = "Funny chicken <Image of a chicken with a tiny helmet on its head> 'Safety first' 0.0 [+1: 0, -1: 0] - created by bob123";
        assertEquals(correctStr, funnyChicken.toString());
    }
    
    @Test
    public void equalsTest() {
        //
        assertTrue(funnyChicken.equals(secondChicken));
        
        assertFalse(funnyChicken.equals(sleepyPuppy));
    }
    
    @Test
    public void setAndGetCreatorTest() {
        //Testing the getter
        assertEquals(johnTho, sleepyPuppy.getCreator());
        
        //Testing the setter with a new User
        User newUser = new User("billy");
        funnyChicken.setCreator(newUser);
        assertEquals("billy", funnyChicken.getCreator().getUserName());
    }
    
    @Test
    public void setAndGetBackgroundImageTest() {
        //Getting the background onject from the meme
        assertEquals(puppy, sleepyPuppy.getBackgroundImage());
        
        //Setting the puppy background to the second chicken meme
        secondChicken.setBackgroundImage(puppy);
        assertEquals(puppy, secondChicken.getBackgroundImage());
    }
    
    @Test
    public void setAndGetRatingsTest() {
        Rating[] ratingArray = sleepyPuppy.getRatings();
        
        //Setting the puppy array to the chicken meme
        secondChicken.setRatings(ratingArray);
        
        //Comparing the first element of each array is the same
        assertEquals(sleepyPuppy.getRatings()[0], secondChicken.getRatings()[0]);
    }
    
    @Test
    public void setAndGetCaptionTest() {
        //Getting the caption for the chicken meme
        assertEquals("Safety first", secondChicken.getCaption());
        
        //Setting the puppy caption to the chicken meme
        secondChicken.setCaption("Look at the puppy");
        assertEquals(sleepyPuppy.getCaption(), secondChicken.getCaption());
    }
    
    @Test
    public void setAndGetCaptionVerticalAlignTest() {
        //Getting the alignment of the meme
        assertEquals("bottom", sleepyPuppy.getCaptionVerticalAlign());
        
        //Setting the alignment to a meme with the allowed parameter
        assertTrue(secondChicken.setCaptionVerticalAlign("top"));
        
        //Setting the alignment to a meme with a NOT allowed parameter
        assertFalse(funnyChicken.setCaptionVerticalAlign("left"));
    }
    
    @Test
    public void setAndGetSharedTest() {
        assertFalse(sleepyPuppy.getShared());
        
        assertFalse(funnyChicken.getShared());
        funnyChicken.setShared(true);
        assertTrue(funnyChicken.getShared());
    }
    
    @Test
    public void compareToTest() {
        assertEquals(0, funnyChicken.compareTo(secondChicken));
        
        secondChicken.setShared(true);
        assertEquals(1, funnyChicken.compareTo(secondChicken));
        assertEquals(-1, secondChicken.compareTo(funnyChicken));
    }

}