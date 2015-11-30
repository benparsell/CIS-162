
/**
 * This class has various tests for the Craps class to ensure
 * it is functioning properly.
 * 
 * @author Ben Parsell 
 * @version 10/23/15
 */
public class CrapsTest
{
    /*************************************************
      This is the most basic test
      It will test for one single roll
     *************************************************/
    public static void BasicTest() {
        // Start new craps game
        Craps game = new Craps();
        System.out.println(game.getMessage());
        
        // Rolls dice
        game.comeOut();
        
        // Print out final message
        System.out.println(game.getMessage());
    }
    
    
    /**************************************************
      This is main method
      Tests for one game of craps (until she 
      looses/wins 1 credit.
     **************************************************/
    public static void main(String [] args) {
        // Starts new Craps game
        Craps game = new Craps();
        
        // Prints out welcome message
        System.out.println(game.getMessage());
        
        // While loop runs until credit is won or lost
        while(game.getCredits() == 10) {
            
            if(game.okToRoll()) {
                game.roll();
                System.out.println(game.getMessage());
            }else if(!game.okToRoll()) {
                game.comeOut();
                System.out.println(game.getMessage());
            }
            
        }
        // Prints out final data
        System.out.println("You have " + game.getCredits()
        + " credits");
        
        System.out.println("");
    }
    
    
    /****************************************************
      This is the most advanced test
      It will test until the user looses all credits.
     ****************************************************/
    public static void AdvancedTest() {
        // Starts new craps game
        Craps game = new Craps();
        
        // While loop to continue until credits are less than 1
        while(game.getCredits() > 0) {
            System.out.println("Welcome To My Game");
            
            System.out.println("Game # " + 
            game.getNumGamesPlayed() + " You have " + 
            game.getCredits() + " credits.");
            
            game.comeOut();
            System.out.println(game.getMessage());
            while(game.okToRoll()) {
                game.roll();
                System.out.println(game.getMessage());
            }
            // Print out final data
            System.out.println("You have " + 
            game.getCredits() + " credits");
            
            System.out.println("");
        }
    }
    
}
