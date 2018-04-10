import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class is an implementation of a voting station app. It allows for fast repeat 
 * entry of ID's and this is checked against a database of names and ID's. If the ID 
 * is found the use is informed else the is informed that their ID is not in the
 * database. The database is implemented using hash table. 
 * 
 * @Author Oyama Plati
 */
public class VoterAppGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;
	private JPanel top, bottom;
	private JLabel idLabel;
	private JTextField userId;
	private JButton enter;
  	private JButton next;
	private JTextArea show;	
	private JScrollPane scrollPane;
	private static HashSet set = new HashSet(87072);			
	private static Scanner inputStream = null;			       
	private static Scanner scanner = new Scanner (System.in);
   	
	
	// This subroutine creates a database of 13-digit id numbers
	// and associated names. We scan the database into a hash table.
	public static void main (String[] args) {
		IdGenerator._init_();
	   	scan();
		SwingUtilities.invokeLater (new Runnable () {
			public void run () {
				VoterAppGUI app = new VoterAppGUI ();
			}		
		});
	}
   	
	/**
	 * In this constructor we creates a frame with a ID window, enter button,
	 * next button and result window. We have event handlers for when the user
	 * enters an ID in the ID window and when the user presses the next button. 
	 */
	public VoterAppGUI () {
		super ("Luka");	
		setSize (WIDTH, HEIGHT);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout (new BorderLayout ());
		
		top = new JPanel ();
		add (top, BorderLayout.NORTH);	
		
		top.setLayout (new FlowLayout ());
		idLabel = new JLabel ("ID");
		top.add (idLabel);
		userId = new JTextField ();
      		userId.setColumns(13);
		top.add (userId);
		enter = new JButton ("Enter");
	      	enter.addActionListener (new ActionListener () {
		public void actionPerformed (ActionEvent e) {
			String id = userId.getText (); 
			id.trim();
			Node<Voter> results = set.find(id);
			if (results != null) 
			 	show.setText ((results.getData()).toString());
			else 
			 	show.setText ("Not found");
			}
     		});
		top.add (enter);
      		next = new JButton ("Next");
      		next.addActionListener (new ActionListener () {
		 	public void actionPerformed (ActionEvent e) {
		    		userId.setText (null);
		    		show.setText (null);
		 	}
      		});
		top.add (next);
      
		bottom = new JPanel ();
		add (bottom, BorderLayout.CENTER);
		
		show = new JTextArea (13, 20);
      		scrollPane = 
         		new JScrollPane (show,
                       		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                       		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      		bottom.add (scrollPane);
		
		pack ();
		setVisible (true);
	}
   
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
	        	}
	        	else {
	        		set.insert(new Voter(rawdata[1], rawdata[0]));
	        	}    
	    	}
       
       		inputStream.close();
	}
}
