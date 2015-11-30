import org.junit.Assert;
import org.junit.Test;
/**
 * This class tests several situations with the full program.
 * 
 * @author Ben Parsell 
 * @version 1.0.0 (11/8/15)
 */
public class DatabaseTest
{
    public static void main() {
        // New arraylist
        ZipCodeDatabase db = new ZipCodeDatabase();
        
        // Read file
        db.readZipCodeData("zipcodes.txt");
        
        // Checking total database size
        Assert.assertTrue("Should be over 29,000 items", db.getCount() > 29000);
        
        // Check city name
        ZipCode zip = db.findZip(49401);
        Assert.assertEquals("Expected Allendale", "ALLENDALE", zip.getCity());
        Assert.assertEquals("Expected MI", "MI", zip.getState());
        
        // Test getZipCode
        Assert.assertEquals(49401, zip.getZipCode());
        
        // Get furthest from BELMONT (Should be HI)
        zip = db.findFurthest(49306);
        Assert.assertEquals(96769, zip.getZipCode());
        
        // Testing total zipcodes within radius of BELMONT
        int databaseCount = db.withinRadius(49306, 10).size();
        Assert.assertTrue("Should be equal to 8", databaseCount == 8);
        
        // Testing total miles between BELMONT & ALLENDALE
        int databaseMiles = db.distance(49306, 49401);
        Assert.assertTrue("Should be equal to 23", databaseMiles == 23);
        
        // Testing total zipcodes within radius of ALLENDAlE
        databaseCount = db.withinRadius(49401, 10).size();
        Assert.assertTrue("Should be equal to 10", databaseCount == 9);
        
        // Find total zipcodes with search
        int searchCount = db.search("Lendale").size();
        Assert.assertTrue("Should be equal to 4", searchCount == 29);
        
        // Total miles between test
        databaseMiles = db.distance(49401, 90001);
        Assert.assertTrue("Should be equal to 1841", databaseMiles == 1841);
        
        // Test to make sure if statement returns null for invalid zip
        Assert.assertNull(db.findZip(459304));
        
        // Search pink and make sure size of list is correct
        Assert.assertTrue("Should be equal to 1", db.search("pink").size() == 1);
        
        // Check total miles between 94111 & 66502
        Assert.assertTrue("Should be equal to 1,398", db.distance(94111, 66502) == 1398);
    }
}
