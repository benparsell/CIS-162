import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridBagLayout;
/***************************************************************
 * GUI front end to a game of Craps
 * 
 * @author Scott Grissom 
 * @version September 14, 2015
***************************************************************/
public class CrapsGUI extends JFrame implements ActionListener{

    /** visual representation of the dice */
    GVdie d1, d2;
    
    /** buttons */
    JButton comeOutButton, rollButton;
    
    /** labels for message and credits */
    JLabel message, credits;
    
    /** the game of craps object */
    Craps game;    

/****************************************************************
Create all elements and display within the GUI
****************************************************************/        
public static void main(String arg[]){
    CrapsGUI gui = new CrapsGUI();
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setTitle("Ben Parsell's Craps Game");
    gui.pack();
    gui.setVisible(true);
}

/****************************************************************
Create all elements and display within the GUI
****************************************************************/    
public CrapsGUI(){ 

    // create the game object as well as the GUI Frame   
    game = new Craps();
    
    // set the layout to GridBag
    setLayout(new GridBagLayout());
    GridBagConstraints position = new GridBagConstraints();
    
    // create and place the message label
    message = new JLabel();
    message.setText(game.getMessage());
    position.gridx = 2;
    position.gridy = 0;
    position.insets = new Insets(5,0,20,0);
    add(message, position);
    
    // get Die #1 from game and place on frame
    d1 = game.getDie(1);
    position.gridx = 0;
    position.gridy = 1;
    add(d1, position);
    
    // get Die #2 from game and place on frame
    d2 = game.getDie(2);
    position.gridx = 3;
    position.gridy = 1;
    add(d2, position);

    
    // create and place the Come Out button
    comeOutButton = new JButton("Come Out");
    position.gridx = 0;
    position.gridy = 3;
    add(comeOutButton, position);
    
    // create and place the Roll button
    rollButton = new JButton("Roll");
    position.gridx = 3;
    position.gridy = 3;
    add(rollButton, position);
    rollButton.setEnabled(false);

     
    // create and position the Credits label
    credits = new JLabel();
    credits.setText("Credits: " + game.getCredits());
    position.gridx = 2;
    position.gridy = 2;
    position.gridwidth = 2;
    position.insets = new Insets(10,0,10,0);
    add(credits, position);
    
    
    
    // register the listeners
    comeOutButton.addActionListener(this);
    rollButton.addActionListener(this);
    
}


/****************************************************************
Inner class to repond to the user action

@param e - the JComponent just selected
****************************************************************/
    public void actionPerformed(ActionEvent event){

    // test for come out and then game.comeOut & vise versa()
    if(event.getSource() == comeOutButton) {
        game.comeOut();
    } else if(event.getSource() == rollButton) {
        game.roll();
    }
    
           
    // enable/disable each button based on status of game
    if(game.okToRoll() == true){
            comeOutButton.setEnabled(false);
            rollButton.setEnabled(true);
        }
        else if(game.okToRoll() == false){
            rollButton.setEnabled(false);
            comeOutButton.setEnabled(true);
        }
    
    // update the labels
    credits.setText("Credits " + game.getCredits());
    message.setText(game.getMessage());
}
}
