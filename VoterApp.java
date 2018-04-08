import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * This class is implementation for the user interface. 
 * This class scans data from the database and 
 * stores it in a hash table to perform some operations.
 * @author Oyama Plati
 */
public class VoterApp {
	private static HashSet set = new HashSet(87072);			// The hash table to be used 
	private static Scanner inputStream = null;			// The file i/o stream
	private static Scanner scanner = new Scanner (System.in); // Keyboard i/o stream
	
	public static void main (String[] args) {
		// We create a database of 13-numerical id numbers and associated names
		IdGenerator._init_();
		// We scan the database into hash set
		scan();
		
	    char answer;
	    do {
	    	
	    	System.out.println("Enter your ID number: ");
	    	String id = scanner.nextLine();
	    	id.trim();
	    	
         //System.out.println("Your id: " + id);
         
         //scanner.nextLine();
	    	
         Node<Voter> results = set.find(id);
	    	if (results != null) 
	    		System.out.println(results.getData());
	    	else 
	    		System.out.println("Not found");
	    	
	    	System.out.println("Continue (y/n) ? ");
	    	answer = (scanner.nextLine()).charAt(0);
	    	
	    }while (answer == 'y' || answer == 'Y');
	} // End of main
	
	/**
	 * This subroutine scans the information from database into a hash table
	 */
	public static void scan () {
		try {
			  inputStream = new Scanner(
			      new FileInputStream(
			      (new File("idAndNames.dat")).getAbsolutePath()));
		}
		catch (FileNotFoundException e) {
		     e.printStackTrace();
		     System.out.println("File does not exist");
		     System.out.println("or could not be open.");
	    }
		
		String line = null;
	     
	    while (inputStream.hasNextLine()) {
	    	line = inputStream.nextLine();
	         
	        String[] rawdata = line.split(" ");
	         
	        if (rawdata.length > 2) {
	           set.insert(
	              new Voter(rawdata[1] + " " + rawdata[2], rawdata[0]));
              /*System.out.println("Insert into hashset: " + rawdata[0] 
                     + " " + rawdata[1] + " " + rawdata[2]);*/
	        }
	        else {
	        	set.insert(new Voter(rawdata[1], rawdata[0]));
            //System.out.println("Insert into hashset: " + rawdata[0] + " " + rawdata[1]);
	        }    
	    }
       
       inputStream.close();
	} // End of scan
}
