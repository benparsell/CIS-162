import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class provides core algorithims to the GUI
 * 
 * @author Ben Parsell
 * @version 1.0.0 (11/2/15)
 */
public class ZipCodeDatabase
{
    /** Initialize new list **/
    ArrayList<ZipCode> list;

    /***********************************************************
     * Default Constuctor that instaniates new ArrayList 
     * list
     **********************************************************/
    public ZipCodeDatabase() {
        list = new ArrayList<ZipCode>();
    }

    
    /***********************************************************
     * Method finds zip code info with given zip code
     * 
     * @param zip Zip Code
     * 
     * @return s returns an object from ArrayList s
     * else
     * @return will return null if nothing happens above
     **********************************************************/
    public ZipCode findZip(int zip) {
        // Cycle through arraylist to search for zip
        for(ZipCode s : list) {
            if(s.getZipCode() == zip) {
                return s;
            }
        }
        // return null if no match
        return null;
    }


    /***********************************************************
     * Method finds the distance in miles between two zip codes
     * 
     * @param zip1 First Zip Code
     * @param zip2 Second Zip Code
     * 
     * @return returns final milage output
     **********************************************************/
    public int distance(int zip1, int zip2) {
        // Set new arraylists equal to found zip codes (findzip)
        ZipCode z1 = findZip (zip1);
        ZipCode z2 = findZip (zip2);
        
        // Final int for Earth's size
        final int EARTH_RADIUS = 3959;

        // Return -1 if null, can't return null here or crash will occur somewhere
        if(z1 == null || z2 == null) {
            return -1;
        }
        
        
        // Change z1 and z2 from degrees to radians
        double lat1=Math.toRadians(z1.getLatitude());
        double lon1=Math.toRadians(z1.getLongitude());
        double lat2=Math.toRadians(z2.getLatitude());
        double lon2=Math.toRadians(z2.getLongitude());            

        // Math function for distance
        double p1= Math.cos(lat1)*Math.cos(lon1)*Math.cos(lat2)*Math.cos(lon2);
        double p2= Math.cos(lat1)*Math.sin(lon1)*Math.cos(lat2)*Math.sin(lon2);
        double p3= Math.sin(lat1)*Math.sin(lat2);

        // Return final value as integer
        return (int) (Math.acos(p1+p2+p3) * EARTH_RADIUS);
    }

    
    /***********************************************************
     * Method to find all zip codes within a given radius
     * 
     * @param pZip zip code for distance method
     * @param pRadius Radius for distance method
     * 
     * @return results ArrayList holding all zipcodes found
     **********************************************************/
    public ArrayList <ZipCode> withinRadius(int pZip, int pRadius) {
        ArrayList <ZipCode> results = new ArrayList<ZipCode>(); // New arraylist

        // First if statement checks for errors
        if(findZip(pZip) != null) {
            // Cycle through arraylist 
            for(ZipCode z : list) {
                // Call distance method
                int dist = distance(pZip, z.getZipCode());
                // add ZipCode if boolean is correct
                if(dist <= pRadius && dist > 0) {
                    results.add(z);
                }

            }
        }
        // Final return
        return results;
    }
    
    
    /***********************************************************
     * Method for ArrayList size
     * 
     * @return list.size() size of ArrayList
     **********************************************************/
    public int getCount() {
        return list.size();
    }

    
    /***********************************************************
     * Method to find furthest zip code from given zip code
     * 
     * @param pZip local variable for zip code
     * @return maxZipCode furthest zip code
     **********************************************************/
    public ZipCode findFurthest(int pZip) {
        // Create new int and new Arraylist below that
        int maxDistance = -1;
        ZipCode maxZipCode = null;

        // Cycle through arraylist
        for ( ZipCode zipCode : list){
            // Call distance method
            int distance = distance(pZip, zipCode.getZipCode());
            // If boolean is true change maxZip and maxDistance
            if (distance  > maxDistance){
                maxZipCode = zipCode;
                maxDistance = distance;
            }
        }
        return maxZipCode;

    }

    
    /***********************************************************
     * Search method to find a ZipCode from ArrayList
     * 
     * @param str local string for boolean expression
     * @return zipCodes ArrayList of matched zip codes
     **********************************************************/
    public ArrayList <ZipCode> search(String str) {
        // Creates new arraylsit
        ArrayList<ZipCode> zipCodes = new ArrayList<ZipCode>();
        
        // Change string to uppercase letters
        str = str.toUpperCase();

        // Cycle through arraylist
        for (ZipCode myZip : list){
            // If boolean is true add zipcode to new arraylist
            if(myZip.getCity().contains(str)|| myZip.getState().contains(str))
                zipCodes.add(myZip);
        }
        return zipCodes;
    }

    
    /***********************************************************
     * Method to read local file off client's storage
     **********************************************************/
    public void readZipCodeData(String filename){
        Scanner inFS = null;
        FileInputStream fileByteStream = null;

        try{
            // open the File and set delimiters
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter("[,\r\n]+");

            // continue while there is more data to read
            while(inFS.hasNext()) {

                // read five data elements
                int zipCode = inFS.nextInt();
                String city = inFS.next();
                String state = inFS.next();
                double latitude = inFS.nextDouble();
                double longitude = inFS.nextDouble();

                // Create new arraylist and add Zipcodes to it
                ZipCode s = new ZipCode(zipCode,city,state,latitude,longitude);
                list.add(s);
            }
            fileByteStream.close();

            // Could not find file
        }catch(FileNotFoundException error1) {
            System.out.println("Failed to read the data file: " + filename);
            // error while reading the file
        }catch(IOException error2) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
}
