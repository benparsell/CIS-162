import org.junit.Assert;
import org.junit.Test;
/***********************************************************
 * Write a description of class gameTest here.
 * 
 * @author Ben Parsell
 * @version 1.0.0 12/5/15
 **********************************************************/
public class gameTest
{
    public static void main(String [] args) {
        Game g = new Game();
        
        System.out.println("============= Software Testing ==========");
        // Test Pickup Method && list
        g.pickup("M1 Garand");
        g.list();
        if(!g.getMessage().equals("M1 Garand \n")) {
            System.out.println("Error with pickup/list method.");
        }
        
        // Test Move method
        g.move("north");
        System.out.println("This location description should be for sceondStoryFarmHouse. It is: " + g.getCurrentLocation().getLongDescription());
        
        // Test help method
        g.help();
        if(!g.getMessage().equals("You are an American paratropper behind enemy lines. You need to eliminate the German general before you can\n safely reconnect with your men. Look for the German camp... \n")) {
            System.out.println("Error with help method");
        }
        
        // Test fire/continue game (they work alongside each other)
        g.fire();
        g.continueGame();
        g.pickup("Grenade");
        g.list();
        if(!g.getMessage().equals("M1 Garand \n" + "" + "Grenade \n")) {
            System.out.println("Error with fire/continueGame.");
        }

        // Test gameOver Method
        g.move("downstairs");
        g.move("south");
        if(!g.gameOver()) {
            System.out.println("Error with gameOver.");
        }
        
        // Start new game
        g = new Game();
        
        // Test Eat Method
        g.pickup("M1 Garand");
        g.move("north");
        g.fire();
        g.continueGame();
        g.pickup("Grenade");
        g.move("downstairs");
        g.fire();
        g.continueGame();
        g.pickup("Apple");
        g.eat("Apple");
        if(!g.getMessage().equals("Yum that was a tasty Apple!\n")) {
            System.out.println("Error with eat method");
        }
        
        // Test drop method
        g.drop("M1 Garand");
        g.pickup("M1 Garand");
        g.list();
        if(!g.getMessage().equals("Grenade \n"  + "" + "M1 Garand \n" )) {
            System.out.println("Error with drop method");
        }
        
        // Test istimeToSearch
        g.move("north");
        g.fire();
        if(!g.isTimeToSearch()) {
            System.out.println("Error with isTimeToSearch");
        }
        System.out.println("=========================================");
        
        // Test look
        g.continueGame();
        g.pickup("M1 Garand Ammo");
        g.look();
        if(!g.getMessage().equals("You are in A fenced-in backyard with a horse stable..\n\n")) {
            System.out.println("Error with look");
        }
        
        // To win the game...
        System.out.println();
        System.out.println("========== Game Playthrough(win) ========");
        g = new Game();
        g.pickup("M1 Garand");
        g.move("north");
        g.fire();
        g.continueGame();
        g.pickup("Grenade");
        g.move("downstairs");
        g.fire();
        g.continueGame();
        g.move("south");
        g.move("south");
        g.move("east");
        g.fire();
        g.continueGame();
        g.move("south");
        g.fire();
        g.continueGame();
        g.move("east");
        g.fire();
        g.continueGame();
        g.pickup("Radio");
        g.move("north");
        g.gameOver();
        System.out.println(g.getMessage());
        System.out.println("=========================================");
        
        // Lose round 1
        System.out.println();
        System.out.println("========== Game Playthrough(lose) ========");
        g = new Game();
        g.pickup("M1 Garand");
        g.move("north");
        g.move("downstairs");
        g.gameOver();
        System.out.println(g.getMessage());
        System.out.println("=========================================");
        
        
        // Lose round 2
        System.out.println();
        System.out.println("========== Game Playthrough(lose) ========");
        g = new Game();
        g.pickup("M1 Garand");
        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        g.fire();
        System.out.println(g.getMessage());
        g.continueGame();
        System.out.println(g.getMessage());
        g.pickup("Grenade");
        System.out.println(g.getMessage());
        g.move("downstairs");
        System.out.println(g.getMessage());
        g.fire();
        System.out.println(g.getMessage());
        g.continueGame();
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.gameOver();
        System.out.println(g.getMessage());
        System.out.println("=========================================");
    }
}
