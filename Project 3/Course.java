import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of class course here.
 * 
 * Ben Parsell
 * Lab 10 11/3/2015
 */
public class course
{
    // instance variables - replace the example below with your own
    private ArrayList<Student> students;

    public course()
    {
        students = new ArrayList<Student>();
    }

    public void readStudentData(String filename){
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
                String first = inFS.next();
                String last = inFS.next();
                int age = inFS.nextInt();
                double gpa = inFS.nextDouble();

                // FIX ME: instantiate a new Student and add to ArrayList
                // this should be two lines of code
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

    public void printRoster()
    {
        for (Student std : students){
            System.out.println(std);
        }
    }

    public ArrayList<Student> probationList()
    {
        ArrayList<Student> probation = new ArrayList<Student>();
        for (Student std : students){
            if (std.getGpa() < 2.0){
                probation.add(std);
            }
        }
        return probation;
    }

    public Student findHighestGrade()
    {
        Student val = students.get(0);
        for (Student std : students) {
            if (std.getGpa() > val.getGpa()){
                val = std;
            }
        }
        return val;
    }

    public static void main(String [ ] args) {
        course gvsu = new course();
        gvsu.readStudentData("StudentInfo.txt");
        gvsu.printRoster();
        System.out.println(gvsu.findHighestGrade());
        System.out.println(gvsu.probationList());

    }

}