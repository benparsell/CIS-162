/**
 * This program creates a game of Craps.
 * 
 * @author Ben Parsell
 * @version 1.0.0 (10/14/15)
 */
public class Craps
{
    /** Instaniate dice **/
    private GVdie d1, d2; 
    
    /** Instantiate current game point **/
    private int currentPoint;
    
    /** Instaniate credit balance **/
    private int creditBalance;
    
    /** Instaniate the current message **/
    private String currentMessage;
    
    /** Instaniate boolean for comeOut **/
    private boolean comeOut;
    
    /** Instaniate amount of games **/
    private int numGames;

    
    /*************************************************************
      This is the default constructor
      The Contstructor initializes instance variables
     ************************************************************/
    public Craps() {
        // initialize dice
        d1 = new GVdie();
        d2 = new GVdie();
        
        // initialize comeOut boolean
        comeOut = true;
        
        // initialize credits to 10
        creditBalance = 10;
        
        // initialize point to -1
        currentPoint = -1;
        
        // initialize number of games
        numGames = 1;
        
        // initialize message
        this.currentMessage = "Welcome to Ben's game";
    }
    
    
    /**************************************************************
     Checks to see if it is the correct time to roll 
      
      @return returns the the opposite of comeOut
     *************************************************************/
    public boolean okToRoll() {
       return !comeOut;
    }
    
    
    /*************************************************************
     Retrieves credit amount from private variable
      
     @return returns the private credit variable 
     *************************************************************/
    public int getCredits() {
        return creditBalance;
    }
    
    
    /*************************************************************
     Retrieves the current point in the game 
      
     @return returns the private currentPoint variable 
     *************************************************************/
    public int getPoint() {
        return currentPoint;
    }
    
    
    /************************************************************
     Retrieves the current message in the game 
      
     @return returns the private currentMessage variable 
     ************************************************************/
    public String getMessage() {
        return currentMessage;
    }
    
    
    /************************************************************
      Retrieves one dice for the game
      
      @param num local variable to decipher which die to choose
     ************************************************************/
    public GVdie getDie(int num) {
      if(num == 1){
           return d1;
        }else {
           return d2;
        }
    }
    
    
   
    /*************************************************************
      Changes the amount of credits the user has when called
      
     @param amount local variable to change credit balance 
     *************************************************************/
    public void setCredits (int amount) {
        if(amount >= 0) {
            creditBalance = amount;
        }
    }
   
    
    /**************************************************************
     Retrieves the number of games that have been played  
      
     @return private variable for number of games 
     **************************************************************/
    public int getNumGamesPlayed(){
        return numGames;      
    }
    
    
    /***************************************************************
     Core programming for comeOut functions 
        Will come out if is timeto come out and if user has at 
        least 1 credit 
      
     ***************************************************************/
    public void comeOut() {
        // Checks if okay to come out and user has at least 1 credit
        if(comeOut && creditBalance > 0) {
            // Roll dice
            d1.roll();
            d2.roll();
            
            // Create local variables for sum
            int die1 = d1.getValue();
            int die2 = d2.getValue();
            int sum = die1 + die2;
            
            // Determines if user wins, loses, or rolls again
            if(sum == 7 || sum == 11) {
                creditBalance++;
                numGames++;
                currentMessage = "You rolled " + sum + 
                ". You win one credit!";
            }else if(sum == 2 || sum == 3 || sum == 12) {
                creditBalance--;
                numGames++;
                currentMessage = "You rolled " + sum + 
                ". You lose one credit!";
            }else {
                currentPoint = sum;
                comeOut = false;
                currentMessage = "You rolled " + sum +
                ". Roll again!";
            }
        }else {
            currentMessage = "It is not time to come out";
        }
    } // End Come Out
   
    
    /**********************************************************
     Core programming for roll functions 
        Will roll dice if it is okay to roll and user has 
        at least 1 credit
      
     **********************************************************/
    public void roll() {
        // Checks if okay to roll and user has at least 1 credit
        if(okToRoll() && creditBalance > 0) {
            // Roll dice
            d1.roll();
            d2.roll();
            
            // Create local variables for sum
            int die1 = d1.getValue();
            int die2 = d2.getValue();
            int sum = die1 + die2;
            
            // Finds out whether user wins, loses, or keeps rolling
            if(sum == 7) {
               creditBalance--;
               numGames++;
               comeOut = true;
               currentPoint = -1;
               currentMessage = "You rolled " + sum +
               ". You lose one credit!";
            }else if(sum == currentPoint) {
                creditBalance++;
                numGames++;
                comeOut = true;
                currentPoint = -1;
                currentMessage = "You rolled " + sum +
                ". You win one credit!";
            }else {
                currentMessage = "You rolled " + sum +
                " keep rolling.";
            }
        }else {
            currentMessage = "It is not time to roll!";
        }
    } // End roll
}
