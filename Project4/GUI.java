import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/*************************************************************
 * GUI for a Zip Code Database
 * 
 * @author Scott Grissom
 * @version October 7, 2015
 ************************************************************/
public class GUI extends JFrame implements ActionListener{

    /** the analyzer that doe all the real work */
    ZipCodeDatabase database;

    /** Buttons **/
    JButton distance, find, within, search, furthest;

    /** Results */
    JTextArea results;

    /** Text Field items **/
    JTextField zip1;
    JTextField zip2;
    JTextField radius;
    JTextField name;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem openItem;  

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Ben Parsell");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public GUI(){
        // instantiate the analyzer and read the data file    
        database = new ZipCodeDatabase();

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 11 rows
        results = new JTextArea(20,20);
        JScrollPane scrollPane = new JScrollPane(results);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 11;  
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 20;
        add(scrollPane, loc);
        loc = new GridBagConstraints();

        // create Results label
        loc.gridx = 0;
        loc.gridy = 0;
        loc.insets.bottom = 20;
        add(new JLabel("Results"), loc);

        // create Choices label
        loc.gridx = 3;
        loc.gridy = 0;
        add(new JLabel("Choices"), loc);
        loc = new GridBagConstraints();        

        // ZipCode 1 Label 
        loc.gridx = 2;
        loc.gridy = 2;
        loc.anchor = loc.LINE_START;
        add(new JLabel("ZipCode 1"), loc);

        // ZipCode 1 Text Field
        zip1 = new JTextField(6);
        zip1.setName("ZipCode1");
        loc.gridx = 3;
        loc.gridy = 2;
        loc.insets.left = 10;
        loc.anchor = loc.LINE_START;
        add(zip1, loc);
        loc = new GridBagConstraints();  

        // ZipCode 2 Label 
        loc.anchor = loc.LINE_START;
        loc.gridx = 2;
        loc.gridy = 3;
        add(new JLabel("ZipCode 2"), loc);

        // ZipCode 2 Text Field
        zip2 = new JTextField(6);
        zip2.setName("ZipCode2");
        loc.gridx = 3;
        loc.gridy = 3;
        loc.insets.left = 10;
        loc.anchor = loc.LINE_START;
        add(zip2, loc);
        loc = new GridBagConstraints(); 

        // Radius Label 
        loc.anchor = loc.LINE_START;
        loc.gridx = 2;
        loc.gridy = 4;
        add(new JLabel("Radius"), loc);

        // Radius Text Field
        radius = new JTextField(6);
        radius.setName("Radius");
        loc.gridx = 3;
        loc.gridy = 4;
        loc.anchor = loc.LINE_START;
        loc.insets.left = 10;
        add(radius, loc);
        loc = new GridBagConstraints(); 

        // Name Label
        loc.anchor = loc.LINE_START;
        loc.gridx = 2;
        loc.gridy = 5;
        add(new JLabel("Name"), loc);

        // Name Text Field
        name = new JTextField(10);
        loc.gridx = 3;
        loc.gridy = 5;
        loc.insets.left = 10;
        loc.anchor = loc.LINE_START;
        add(name, loc);

        // Distance button
        distance = new JButton("distance between 1 and 2");
        loc.gridx = 2;
        loc.gridy = 6;
        loc.gridwidth = 2;
        loc.insets.top = 20;
        loc.insets.right = 20;
        loc.anchor = loc.CENTER;
        add(distance, loc);

        // Find Zip button
        find = new JButton("find Zip 1");
        loc.gridx = 2;
        loc.gridy = 7;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        add(find, loc);

        // Within Radius button
        within = new JButton("within radius of Zip 1");
        loc.gridx = 2;
        loc.gridy = 8;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        add(within, loc);

        // Search Button
        search = new JButton("search by name");
        loc.gridx = 2;
        loc.gridy = 9;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        add(search, loc);

        // Furthest button
        furthest = new JButton("furthest from Zip 1");
        loc.gridx = 2;
        loc.gridy = 10;
        loc.gridwidth = 2;
        loc.insets.top = 10;
        loc.insets.right = 20;
        add(furthest, loc);

        // add action listeners for buttons
        find.addActionListener(this);
        within.addActionListener(this);
        search.addActionListener(this);
        furthest.addActionListener(this);
        distance.addActionListener(this); 

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        openItem = new JMenuItem("Open...");
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // Action listeners for menu items
        fileMenu.addActionListener(this);
        openItem.addActionListener(this);
        quitItem.addActionListener(this);

    }

    /*****************************************************************
     * Search city and state for any match
     ****************************************************************/ 
    private void searchByName(){

        // retrieve the zip codes with the matching String
        ArrayList <ZipCode> list = database.search(name.getText());

        // dislay the results
        results.setText("city / states that contain '"+name.getText()+"'\n\n");
        for (ZipCode z : list){
            results.append(z + "\n");
        }
        results.append("\nTotal: " + list.size());
    }

    /*****************************************************************
     * Calculate distances between two zip codes if the textfields
     * constain valid integers
     ****************************************************************/ 
    private void calcDistance (){
        // Make sure zipcode 1 text field has an integer
        if(checkValidInteger(zip1.getText(), zip1.getName()) == true) {
            // Make sure radius text field has integer
            if(checkValidInteger(zip2.getText(), zip2.getName()) == true) {
                // Parse zipcode 1 and 2
                int z1 = Integer.parseInt(zip1.getText());
                int z2 = Integer.parseInt(zip2.getText()); 
                
                // Call distance method
                int dist = database.distance(z1,z2);

                // Convert to string to display to GUI
                String loc1 = database.findZip(z1).toString();
                String loc2 = database.findZip(z2).toString();

                // Print to GUI
                results.setText("The distance betwen \n" 
                    + loc1+" and \n"+loc2+" is " + dist+" miles");
            }
        }
    }

    /*****************************************************************
     * find a zip code
     ****************************************************************/ 
    private void findZip (){
        // Make sure ZipCode1 text field has integer
        if(checkValidInteger(zip1.getText(), zip1.getName()) == true) {
            // Grabs/Parses zipcode in textfield
            int z1 = Integer.parseInt(zip1.getText());
            
            // Searches for zipcode
            ZipCode z = database.findZip(z1);

            // if no zip code found
            if (z == null)
                results.setText("no city found with zip code " + z1);
            else
                results.setText(z.toString());
        }
    }

    /*****************************************************************
     * find a zip code
     ****************************************************************/ 
    private void findFurthest (){
        // Make sure ZipCode1 text field has integer
        if(checkValidInteger(zip1.getText(), zip1.getName()) == true) {
            // Grabs/Parses zipcode in textfield
            int z1 = Integer.parseInt(zip1.getText());
            
            // Finds furthest zipcode away
            ZipCode z = database.findFurthest(z1);

            // if no zip code found
            if (z == null)
                results.setText("no city found with zip code " + z1);
            else
                results.setText(z.toString());
        }
    }

    /*****************************************************************
     * find zips within a specific radius
     ****************************************************************/ 
    private void findZipsWithinRadius (){
        // Make sure ZipCode1 text field has integer
        if(checkValidInteger(zip1.getText(), zip1.getName()) == true) {
            // Make sure radius text field has integer
            if(checkValidInteger(radius.getText(), radius.getName()) == true) {
                  // Grabs/Parses zipcode in textfield
                int z1 = Integer.parseInt(zip1.getText());

                // Parse and call radius method
                int z2 = Integer.parseInt(radius.getText());
                ArrayList<ZipCode> zipRadius = new ArrayList <ZipCode>();
                zipRadius = database.withinRadius(z1, z2);
                
                // Results Title
                results.setText("Zipcodes that are within '"  +radius.getText()+"' miles\n\n");
                
                // Run through arraylist and add all within radius
                for (ZipCode z : zipRadius){
                    results.append(z + "\n");
                }
                results.append("\nTotal: " + zipRadius.size());
            }
        }
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * @param e the event that was fired
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){
        JComponent buttonPressed = (JComponent) e.getSource();
        
        // find button
        if (buttonPressed == find)   
            findZip(); 
        // search button
        else if (buttonPressed == search)
            searchByName();
        // within button
        else if (buttonPressed == within)
            findZipsWithinRadius();
        // distance button
        else if (buttonPressed == distance)
            calcDistance();
        // furthest
        else if (buttonPressed == furthest)
            findFurthest();
        // openfile menuitem    
        else if (buttonPressed == openItem)
            openFile();
        // quit menuitem
        else if (buttonPressed == quitItem)
            dispose();

    }

    /*****************************************************************
     * open a data file with the name selected by the user
     ****************************************************************/ 
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            database.readZipCodeData(filename);          
        }
    }

    /*****************************************************************
     * Check if the String contains a valid integer.  Display
     * an appropriate warning if it is not valid.
     * 
     * @param numStr - the String to be checked
     * @param label - the textfield name that contains the String
     * @return true if valid
     ****************************************************************/   
    private boolean checkValidInteger(String numStr, String label){
        boolean isValid = true;
        try{
            int val = Integer.parseInt(numStr);

            // display error message if not a valid integer    
        }catch(NumberFormatException e){
            isValid = false;
            JOptionPane.showMessageDialog(this, "Enter an integer in " + label);

        }    
        return isValid;
    }
}