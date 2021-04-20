package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OrderableFeed extends Feed {
    
    public void sortByCaption() {
        Collections.sort(this.getMemes());
    }
    
    public void sortByRating() {
        Collections.sort(this.getMemes(), new CompareMemeByRating());
    }
    
    public void sortByCreator() {
        Collections.sort(this.getMemes(), new CompareMemeByCreator());
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
        
        //Creating and settting ratings
        funnyDuck.addRating(new Rating(bob123, 1));
        funnyDuck.addRating(new Rating(tinaaa, 1));
        funnyChicken.addRating(new Rating(johnTho, 1));
        
        //Creating Feed objects
        OrderableFeed feed1 = new OrderableFeed();
        
        //Creating an array to pass to the Feed object
        ArrayList<Meme> randomMemeList = new ArrayList<Meme>(Arrays.asList(funnyChicken, sleepyPuppy, sleepyKitten, secondChicken, funnyDuck)); // Used this resource https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/ to help with this line of code
        
        //Creating comparators
        CompareMemeByRating compareRating = new CompareMemeByRating();
        CompareMemeByCreator compareCreator = new CompareMemeByCreator();
        
        //Meme CompareTo and comparators
        System.out.println("--------------- Test 1 ---------------");
        System.out.println(sleepyKitten.compareTo(funnyDuck));
        System.out.println(funnyDuck.compareTo(sleepyKitten));
        System.out.println(compareRating.compare(funnyDuck, sleepyKitten));
        System.out.println(compareCreator.compare(funnyDuck, sleepyKitten));
        
        //Background compareTo
        System.out.println("--------------- Test 2 ---------------");
        System.out.println(kitten.compareTo(chicken));
        System.out.println(chicken.compareTo(kitten));
        
        //User compareTo
        System.out.println("--------------- Test 3 ---------------");
        System.out.println(bob123.compareTo(tinaaa));
        System.out.println(tinaaa.compareTo(bob123));
        
        //Sorting
        System.out.println("--------------- Original ---------------");
        feed1.setMemes(randomMemeList);
        bob123.setMemesViewed(randomMemeList);
        
        System.out.println(feed1.toString());
        System.out.println(feed1.getNewMeme(bob123)); //null since the user saw everything in the feed
        
        System.out.println("--------------- Sorted by caption ---------------");
        ArrayList<Meme> johnThoMemeViewed = new ArrayList<Meme>(Arrays.asList(sleepyKitten));
        
        feed1.sortByCaption();
        johnTho.setMemesViewed(johnThoMemeViewed);
        
        System.out.println(feed1.toString());
        System.out.println(feed1.getNewMeme(johnTho)); //Returns the second item
        
        System.out.println("--------------- Sorted by creator ---------------");
        feed1.sortByCreator();
        System.out.println(feed1.toString());
        
        System.out.println("--------------- Sorted by rating ---------------");
        feed1.sortByRating();
        System.out.println(feed1.toString());
    }
}