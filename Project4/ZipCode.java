
/**
 * These are the base methods for the ZipcodeDatabase class.
 * 
 * @author Ben Parsell 
 * @version 1.0.0 (11/1/15)
 */
public class ZipCode
{
    /** ZipCode **/
    private int zipCode;

    /** City Name **/
    private String city;

    /** State Name **/
    private String state;

    /** Latitude in degrees **/
    private double latitude;

    /** Longitude in degrees **/
    private double longitude;

    /***********************************************************
     * Default Constuctor that initializes global variables
     **********************************************************/
    public ZipCode (int pZip) {
        zipCode = pZip;
        city = "UNKNOWN";
        state = "ST";
        latitude = 0.0;
        longitude = 0.0;
    }

    /***********************************************************
     * Constuctor that allows user to initialize variables
     **********************************************************/ 
    public ZipCode (int pZip, String pCity, String pState, double pLat, double pLon) {
        zipCode = pZip;
        city = pCity;
        state = pState;
        latitude = pLat;
        longitude = pLon;
    }

    
    
    /***********************************************************
     * Method to retrieve Zip Code
     * 
     * @return zipCode retrieves Zip Code
     **********************************************************/
    public int getZipCode() {
        return zipCode;
    }

    
    /***********************************************************
     * Method to change zip code
     * 
     * @param zip local variable for zip code
     **********************************************************/
    public void setZipCode(int zip) {
        zipCode = zip;
    }

    
    /***********************************************************
     * Method to retrieve city name
     * 
     * @return city this holds the city name
     **********************************************************/
    public String getCity() {
        return city;
    }

    
    /***********************************************************
     * Method to change city name
     * 
     * @param c local variable for city name
     **********************************************************/
    public void setCity(String c) {
        city = c;
    }

    
    /***********************************************************
     * Method to retrieve state initials
     * 
     * @return state this holds the state initial
     **********************************************************/
    public String getState() {
        return state;
    }

    
    /***********************************************************
     * Method to change state
     * 
     * @param st local variable for state initials
     **********************************************************/
    public void setState(String st) {
        state = st;
    }

    
    /***********************************************************
     * Method to retrieve Latitude
     * 
     * @return latitude returns the latitude of the Zip Code
     **********************************************************/
    public double getLatitude() {
        return latitude;
    }

    
    /***********************************************************
     * Method to change the latitude
     * 
     * @param lat local variable for latitude
     **********************************************************/
    public void setLatitude(double lat) {
        latitude = lat;
    }

    
    /***********************************************************
     * Method to retrieve Longitude
     * 
     * @return latitude returns the longitude of the Zip Code
     **********************************************************/
    public double getLongitude() {
        return longitude;
    }

    
    /***********************************************************
     * Method to change the latitude
     * 
     * @param lon local variable for longitude
     **********************************************************/
    public void setLongitude(double lon) {
        longitude = lon;
    }

    
    /***********************************************************
     * Method to change zip code data to a string to avoid
     * weird Java symbols
     **********************************************************/
    public String toString() {
        return city + ", " + state + " " + zipCode; 
    }
}
