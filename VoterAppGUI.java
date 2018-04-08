import java.swing.JFrame;
import java.swing.SwingUtilities;
import java.swing.BorderLayout;
import java.swing.JPanel;
import java.swing.JLabel;
import java.swing.JTextField;
import java.swing.JButton;
import java.swing.JTextArea;

public class VoterAppGUI extends JFrame {

	public static void main (String[] args) {
		SwingUtilities.invokeLater (new Runnable () {
			@Override public void run () {
				VoterAppGUI app = new VoterAppGUI ();
			}		
		});
	}

	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;
	private JPanel top, bottom;
	private JLabel idLabel;
	private JTextField userId;
	private JButton enter;
	private JTextArea show;	
	
	public VoterAppGUI () {
		super ("Voting Station");	
		setSize (WIDTH, HEIGHT);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setLayout (new BorderLayout ());
		
		top = new JPanel ();
		add (top, BorderLayout.NORTH);	
		
		top.setLayout (new FlowLayout ());
		idLabel = new JLabel ("ID");
		top.add (idLabel);
		userId = new JTextField ();
		top.add (userId);
		enter = new JButton ("Enter");
		top.add (enter);
		
		bottom = new JPanel ();
		add (bottom, BorderLayout.CENTER);
		
		
	}
}
