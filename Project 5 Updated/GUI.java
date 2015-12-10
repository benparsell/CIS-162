import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
/**************************************************************
 * The GUI for the Game class.
 * 
 * @author Ben Parsell
 * @version 1.0.0 12/2/2015
 *************************************************************/
public class GUI extends JFrame implements ActionListener{
    /** instantiate new game **/
    Game g;

    /** instantiate Direction Buttons **/
    JButton north;
    JButton south;
    JButton east;
    JButton west;
    JButton downstairs;
    JButton upstairs;

    /** instantiate Action Buttons **/
    JButton look;
    JButton help;
    JButton pickup;
    JButton drop;
    JButton eat;
    JButton list;
    JButton fire;
    JButton continueButton;

    /** instantiate Text area **/
    JTextArea results;

    /** instantiate Menu and items **/
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem newGame;

    /******************************************************
     * Main method
     *****************************************************/ 
    public static void main(String [] args) {
        // Instaniate and Initialize new GUI
        GUI gui = new GUI();
        
        // Shutdown program when exxit
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Final settings
        gui.setTitle("WW2");
        gui.pack();
        gui.setVisible(true);

    }

    /******************************************************
     * GUI constructor which handles positioning and 
     * initializing variables
     *****************************************************/ 
    public GUI() {
        // Initialize a new game
        g = new Game();

        // Initialize Gridbag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();
        
        // Sets up the text area as "results"
        results = new JTextArea(25,60);
        JScrollPane scrollPane = new JScrollPane(results);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 12;
        loc.gridwidth = 10;
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 5;
        add(scrollPane, loc);
        loc = new GridBagConstraints();

        // create results label
        loc.gridx = 5;
        loc.gridy = 0;
        loc.insets.bottom = 20;
        add(new JLabel("Results"), loc);

        // buttons

        // Create directions label
        loc.gridx = 10;
        loc.gridy = 1;
        loc.insets.right = 20;
        add(new JLabel("Directions"), loc);

        // North Button
        north = new JButton("North");
        loc.gridx = 10;
        loc.gridy = 2;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        north.setBackground(Color.cyan);
        add(north, loc);

        // South Button
        south = new JButton("South");
        loc.gridx = 10;
        loc.gridy = 3;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        south.setBackground(Color.cyan);
        add(south, loc);

        // East Button
        east = new JButton("East");
        loc.gridx = 10;
        loc.gridy = 4;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        east.setBackground(Color.cyan);
        add(east, loc);

        // West Button
        west = new JButton("West");
        loc.gridx = 10;
        loc.gridy = 5;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        west.setBackground(Color.cyan);
        add(west, loc);

        // Upstairs button
        upstairs = new JButton("Upstairs");
        loc.gridx = 10;
        loc.gridy = 6;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        upstairs.setBackground(Color.cyan);
        add(upstairs, loc);

        // Down Stairs Button
        downstairs = new JButton("Downstairs");
        loc.gridx = 10;
        loc.gridy = 7;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        downstairs.setBackground(Color.cyan);
        add(downstairs, loc);
        loc = new GridBagConstraints();

        // Actions Label
        loc.gridx = 0;
        loc.gridy = 13;
        loc.anchor = loc.WEST;
        loc.insets.left = 10;
        add(new JLabel("Actions"), loc);
        loc = new GridBagConstraints();

        // Help Button
        help = new JButton("Help");
        loc.gridx = 1;
        loc.gridy = 13;
        loc.gridwidth = 1;
        loc.insets.right = 10;
        loc.insets.left = 10;
        help.setBackground(Color.green);
        add(help, loc);
        loc = new GridBagConstraints();

        // Pickup Button
        pickup = new JButton("Pickup");
        loc.gridx = 2;
        loc.gridy = 13;
        loc.insets.right = 10;
        loc.gridwidth = 1;
        pickup.setBackground(Color.green);
        add(pickup, loc);
        loc = new GridBagConstraints();

        // Drop Button
        drop = new JButton("Drop");
        loc.gridx = 3;
        loc.gridy = 13;
        loc.insets.right = 10;
        loc.gridwidth = 1;
        drop.setBackground(Color.green);
        add(drop, loc);
        loc = new GridBagConstraints();

        // Eat Button
        eat = new JButton("Eat");
        loc.gridx = 4;
        loc.gridy = 13;
        loc.insets.right = 10;
        loc.gridwidth = 1;
        eat.setBackground(Color.green);
        add(eat, loc);
        loc = new GridBagConstraints();

        // look Button
        look = new JButton("Look");
        loc.gridx = 5;
        loc.gridy = 13;
        loc.insets.right = 10;
        loc.insets.right = 10;
        loc.gridwidth = 1;
        look.setBackground(Color.green);
        add(look, loc);
        loc = new GridBagConstraints();

        // List Button
        list = new JButton("List");
        loc.gridx = 6;
        loc.gridy = 13;
        loc.insets.right = 10;
        loc.gridwidth = 1;
        list.setBackground(Color.green);
        add(list, loc);
        loc = new GridBagConstraints();

        // Continue Button
        continueButton = new JButton("Continue");
        loc.gridx = 7;
        loc.gridy = 13;
        loc.gridwidth = 1;
        loc.insets.right = 10;
        continueButton.setBackground(Color.red);
        add(continueButton, loc);
        loc = new GridBagConstraints();

        // Fire Button
        fire = new JButton("Fire");
        loc.gridx = 8;
        loc.gridy = 13;
        loc.gridwidth = 1;
        loc.insets.right = 10;
        fire.setBackground(Color.red);
        add(fire, loc);
        loc = new GridBagConstraints();

        // add action listeners for direction buttons
        north.addActionListener(this);
        south.addActionListener(this);
        east.addActionListener(this);
        west.addActionListener(this);
        downstairs.addActionListener(this);
        upstairs.addActionListener(this);

        // Add Action Listeners for action butons
        help.addActionListener(this);
        pickup.addActionListener(this);
        drop.addActionListener(this);
        eat.addActionListener(this);
        look.addActionListener(this);
        list.addActionListener(this);
        fire.addActionListener(this);
        continueButton.addActionListener(this);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newGame = new JMenuItem("New Game");
        fileMenu.add(newGame);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // Action Listeners for menu items
        fileMenu.addActionListener(this);
        quitItem.addActionListener(this);
        newGame.addActionListener(this);

        // Setup the opening message
        g.setWelcomeMessage();
        results.append(g.getMessage());
        g.look();
        results.append(g.getMessage());

        // We don't want continue on yet
        continueButton.setEnabled(false);
    }

    /******************************************************
     * Method to disable buttons if the game is over
     *****************************************************/ 
    private void gameOver() {
        // Checks for if the gameOver() method is true
        if(g.gameOver() == true) {
            
            // Disable all buttons
            north.setEnabled(false);
            south.setEnabled(false);
            east.setEnabled(false);
            west.setEnabled(false);
            help.setEnabled(false);
            pickup.setEnabled(false);
            drop.setEnabled(false);
            eat.setEnabled(false);
            look.setEnabled(false);
            fire.setEnabled(false);
            list.setEnabled(false);
            downstairs.setEnabled(false);
            upstairs.setEnabled(false);
        }
    }

    /******************************************************
     * Method to start a brand new game... Resets 
     * everything in game
     *****************************************************/ 
    private void newGame() {
        // Initialize new game
        g = new Game();
        
        // Setup opening message
        g.setWelcomeMessage();
        results.setText(g.getMessage());
        g.look();
        results.append(g.getMessage());
        
        // Enable all buttons
        north.setEnabled(true);
        south.setEnabled(true);
        east.setEnabled(true);
        west.setEnabled(true);
        help.setEnabled(true);
        pickup.setEnabled(true);
        drop.setEnabled(true);
        eat.setEnabled(true);
        look.setEnabled(true);
        fire.setEnabled(true);
        list.setEnabled(true);
        downstairs.setEnabled(true);
        upstairs.setEnabled(true);
    }

    /******************************************************
     * Method to track button presses and actions
     * Updates the results screen also
     *****************************************************/ 
    public void actionPerformed(ActionEvent e) {
        JComponent buttonPressed = (JComponent) e.getSource();
        
        // Quit menu item
        if(buttonPressed == quitItem) {
            System.exit(1);
        }
        
        // New game menu item
        if(buttonPressed == newGame) {
            newGame();
        }
        
        // Help button
        if (buttonPressed == help){
            g.help();
            results.append(g.getMessage());
        }
        
        // Pickup button
        if(buttonPressed == pickup) {
            String message = "What do you want to pickup?";
            
            // Check for what user wants to pickup
            String pickup = JOptionPane.showInputDialog(null, message);
            g.pickup(pickup);
            results.append(g.getMessage());
        }
        
        // Drop Button
        if(buttonPressed == drop) {
            String message = "What do you want to drop?";
            
            // Check for what they want to drop
            String drop = JOptionPane.showInputDialog(null, message);
            g.drop(drop);
            results.append(g.getMessage());
        }
        
        // List button
        if(buttonPressed == list) {
            g.list();
            results.append(g.getMessage());
        }        
        
        // Look button
        if(buttonPressed == look) {
            g.look();
            results.append(g.getMessage());
        }
        
        // Fire button
        if(buttonPressed == fire) {
            g.fire();
            results.append(g.getMessage());
            
            // Check if it is time to search, disables button
            if(g.isTimeToSearch()) {
                continueButton.setEnabled(true);
                fire.setEnabled(false);
            }
        }
        
        // Contine button
        if(buttonPressed == continueButton) {
            g.continueGame();
            results.append(g.getMessage());
            continueButton.setEnabled(false);
            fire.setEnabled(true);
        }
        
        // Eat Button
        if(buttonPressed == eat) {
            String message = "What do you want to eat?";
            
            // Check for what user wants to eat
            String eat = JOptionPane.showInputDialog(null, message);
            g.eat(eat);
            gameOver();
            results.append(g.getMessage());
        }
        
        // North button
        if(buttonPressed == north) {
            g.move("north");
            gameOver();
            results.append(g.getMessage());

        }
        
        // South button
        if(buttonPressed == south) {
            g.move("south");
            gameOver();
            results.append(g.getMessage());
        }
        
        // East button
        if(buttonPressed == east) {
            g.move("east");
            gameOver();
            results.append(g.getMessage());
        }
        
        // West button
        if(buttonPressed == west) {
            g.move("west");
            gameOver();
            results.append(g.getMessage());
        }
        
        // Downstairs button
        if(buttonPressed == downstairs) {
            g.move("downstairs");
            gameOver();
            results.append(g.getMessage());
        }
        
        // Upstairs button
        if(buttonPressed == upstairs) {
            g.move("upstairs");
            gameOver();
            results.append(g.getMessage());
        }
    }
}
