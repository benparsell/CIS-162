
/*****************************************************
 * This class builds items for the game.
 * 
 * @author Ben Parsell 
 * @version 1.0.0 (11/19/2015)
 *****************************************************/
public class Item
{
    /** Name of an item **/
    private String name;
    
    /** Description of an item **/
    private String description;
    
    /** Weight of an item **/
    private int weight;
    
    /** Edible value of an item **/
    private boolean edible;
   
    /******************************************************
     * Main Constuctor
     * 
     * @param n the name of an item
     * @param d the description of an item
     * @param w the weight of an item
     * @param e the edible value of an item
     *****************************************************/
    public Item(String n, String d, int w, boolean e) {
        // Initialize instance variables
        name = n;
        description = d;
        weight = w;
        edible = e;
    }
    
    
    /******************************************************
     * Method to set the name of an item.
     * 
     * @param n the name of an item
     *****************************************************/
    public void setName(String n) {
       name = n; 
    }
    
    
    /******************************************************
     * Method to set the description of an item
     * 
     * @param d the description of an item
     *****************************************************/
    public void setDescription(String d) {
       description = d; 
    }
    
    
    /******************************************************
     * Method to set the weight of each item
     * 
     * @param w the weight of an item
     *****************************************************/
    public void setWeight(int w) {
       weight = w; 
    }
    
    
    /******************************************************
     * Method to change the edibile value of each item
     * 
     * param e the edible value of an item
     *****************************************************/
    public void setEdible(boolean e) {
       edible = e; 
    }
    
    
    /******************************************************
     * Method to retrieve name of item
     * 
     * @return name the name of an item
     *****************************************************/
    public String getName() {
        return name;
    }
    
    
    /******************************************************
     * Method to retrieve description of an item
     * 
     * @return description the description of an item
     *****************************************************/
    public String getDescription() {
        return description;
    }
    
    
    /******************************************************
     * Method to retrieve weight of an item
     * 
     * @return weight the weight of the item
     *****************************************************/
    public int getWeight() {
        return weight;
    }
    
    
    /******************************************************
     * Method to retrieve value of item being edible or not
     * 
     * @return edible value of item being edible
     *****************************************************/
    public boolean getEdible() {
        return edible;
    }
    
    
    /******************************************************
     * Method to check if item is edible or not
     * 
     * @return true of false for if item is edible
     *****************************************************/
    public boolean isEdible() {
        // Check if item is edible
        if(edible) {
            return true;
        }
        return false;
    }
}
