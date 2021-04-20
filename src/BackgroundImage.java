package src;

public class BackgroundImage implements Comparable<BackgroundImage>{
    //STATES (Instance variables)
    /**
     * Holds the name of the image
     * */
    private String imageFileName;
    
    /**
     * The title of an image
     * */
    private String title;
    
    /**
     * What the image is about
     * */
    private String description;
    
    //Constructors
    public BackgroundImage(String imageFileName, String title, String description) {
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
    }
    
    public BackgroundImage() {
        this.imageFileName = "No image name given";
        this.title = "No title given";
        this.description = "No description given";
    }
    
    //BEHAVIOR (Methods)
    /**
     * Stringifys an object
     *
     * @return String An object is casted to a string
     */
    @Override
    public String toString() {
        return this.title + " <" + this.description + ">";
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
        if(!(otherObj instanceof BackgroundImage)) return false;
        
        BackgroundImage other = (BackgroundImage) otherObj;
        
        //Checks the parameters
        if((this.imageFileName).equals(other.imageFileName) && 
           (this.title).equals(other.title) && 
           (this.description).equals(other.description)) {
            return true;
        }
        
        return false;
    }
    
    //GETTERS and SETTERS
    /**
     * The file name of the background image
     * 
     * @return String The name of the image
     * */
    public String getImageFileName() {
        return this.imageFileName;
    }
    
    /**
     * Sets the file name to the image
     * 
     * @param String the name to give to the file
     * */
    public void setImageFileName(String imageName) {
        this.imageFileName = imageName;
    }
    
    /**
     * Gets the title of the BackgroundImage object
     * 
     * @return String Return the title of the image
     * */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Sets a title to the background image
     * 
     * @param String the title to set to the image
     * */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the description of the image
     * 
     * @return String The descriotion of the background image object
     * */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Sets what the image is about on the backgroundImage object
     * 
     * @param String The description to set on the image
     * */
    public void setDescription(String description) {
        this.description = description;
    }
    
    //CompareTo method
    @Override
    public int compareTo(BackgroundImage other) {
        
        int nameCompare = this.imageFileName.compareTo(other.imageFileName);
        if(nameCompare != 0) return nameCompare;
        
        int titleCompare = this.title.compareTo(other.title);
        if(titleCompare != 0) return titleCompare;
        
        int descriptionCompare = this.description.compareTo(other.description);
        if(descriptionCompare != 0) return descriptionCompare;
        
        return 0;
    }
    
    public static void main(String[] args) {
        //TESTING
        
        //Creating BackgroundImage objects
        BackgroundImage kitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
        BackgroundImage puppy = new BackgroundImage();
        puppy.setDescription("Image of a puppy sleeping on their little bed");
        puppy.setTitle("Sleeping puppy");
        puppy.setImageFileName("puppy.png");
        BackgroundImage brownKitten = new BackgroundImage("kitten.png", "Sleeping kitten", "Image of a kitten sleeping on their little bed");
        
        //Printing
        System.out.println(puppy.toString());
        System.out.println(kitten.toString());
        System.out.println(brownKitten.toString());
        System.out.println("Does kitten equal puppy: " + kitten.equals(puppy));
        System.out.println("Does kitten equal brown kitten: " + kitten.equals(brownKitten));
        System.out.println("Does puppy equal brown kitten: " + puppy.equals(brownKitten));

        
    } //END MAIN
    
} // END class