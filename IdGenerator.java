import java.util.Scanner;
import java.util.Random;
import java.io.FileInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class creates a database of names and id's.
 * @author Oyama Plati
 */
public class IdGenerator {
 
 // In this subroutine we extract names from a database 
 // Generate unique ID
 // Create a new datafile with IDs and names
 // (names.csv && unique ID)  --> idAndNames.dat 

 public static void _init_ () {
     int count = 0;
     Scanner inputStream = null;       // Tool to read input file
     PrintWriter outputStream = null;  // Tool to write to output file
 
     try {
      // Open streams for io purposes 
      inputStream = new Scanner (
         new FileInputStream ((new File ("names.csv")).getAbsolutePath()));
      outputStream = new PrintWriter (new FileWriter ("idAndNames.dat"));
     }
     catch (FileNotFoundException e0) {
      e0.printStackTrace();
     }
     catch (IOException e1) {
      e1.printStackTrace();
     }
      
      //Send to new database
      while (inputStream.hasNextLine()) {
         
         // Create unique id numbers 
         Random rnd = new Random ();
         int n1 = 100000 + rnd.nextInt(9000000);
         int n2 = 100000 + rnd.nextInt(9000000);
         
         String id = null;
         
         if (n2 != n1) {
            String num1 = String.valueOf(n1);
            String num2 = String.valueOf(n2);
            id = num1.concat(num2);
            
            // Ensure a 13 digit id 
            if (id.length() > 13) {
               id = id.substring(0, id.length()-1);
            }
            else {
               id = id + "0"; // Zero padding
            }
         }
         
         // Extract line from csv file
         String[] raw = (inputStream.nextLine()).split(",");
         // Write to file
         if (raw.length >= 2) {
            // 1 name per person 
            outputStream.println(id + " " + raw[0] + raw[1]);
            count++;
            /*System.out.println("Write to file: " 
                  + id + " " + raw[0] + raw[1]);*/
         }
         else {
            outputStream.println(id + " " + raw[0]);
            count++;
            /*System.out.println("Write to file: " 
                  + id + " " + raw[0]);*/
         }
      } 
      
      System.out.println("The file size: " + count);
      inputStream.close();
      outputStream.close(); 
   } // End of _init_
}