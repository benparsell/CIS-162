
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String [] args) {
        char letter = 'A';
        System.out.print("letter+letter");
    }
    public Student findHighestGrade()
    {
        Student val = students.get(0);
        for (Student s : students) {
            if (s.getGpa() > val.getGpa()){
                val = s;
            }
        }
        return val;
    }
}
