public class BackgroundImage {
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
    public BackgroundImage() {
        
    }
    
    //BEHAVIOR (Methods)
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
     * @param Object Any object passed is conpared to another object
     * @return boolean if the two objects are the same
     */
    @Override
    public boolean equals(Object obj) {
        return true;
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
    
}