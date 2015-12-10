
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
   public static void message() {
       String phrase = "MeetLaFBhuyoeYkTrWoehciu!", result ="";
       int r = (int) Math.sqrt(phrase.length());
       
       for(int i = 0; i < r; i++) {
           for(int j = i; j < phrase.length(); j = j + r) {
               if(Character.isUpperCase(phrase.charAt(j))) {
                   result += (" ");
                }
               result += phrase.charAt(j);
            }
        }
        
       System.out.println("Password is: " + result);
    }
}
