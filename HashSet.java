import java.util.Scanner;
/**
 * An object of this class represents a hash table. A hash table has a table size.
 * @author Oyama Plati
 */
public class HashSet {
	private static final int DEFAULT_TABLE_SIZE = 211;
	private Node [] A;
	
	/**
	 * This constructor creates a hash table of default size
	 */
	public HashSet () {
		this(DEFAULT_TABLE_SIZE);
	}
	
	/**
	 * This constructor creates a hash table of the given size
	 * @param numList The size a the new hash table
	 */
	public HashSet (int numList) {
		A = new Node [numList];
	}
	
	/**
	 * This subroutine obtains the has value for given key : ASCII String using bit rotation
	 * @param key The given key for hashing 
	 * @param tableSize The size of the array
	 * @return Position of object in array
	 */
	public int hashCode (String key, int tableSize)
	{
	    int h = 0;
	    for (int i = 0; i < key.length(); i++)
	    {
	        h = ((h ^ (h << 5) + (h >> 2)) + key.charAt(i)) % tableSize;
	    }
	    return h;
	}
    
	/**
	 * This subroutine adds a new voter into the table at a calculated position
	 * @param x The voter 
	 */
	public void insert (Voter x) {
		int h = hashCode (x.getID().trim(), A.length);
      Node<Voter> p = new Node<Voter> ();
      p.setData(x);
      p.setLink(A[h]);
      A[h] = p;
	}
	
	/**
	 * This subroutine locates a new voter in the hash table 
	 * @param x The target voter
	 * @return The node containing the voter in table
	 */
	public Node<Voter> find (String x) {
		int h = hashCode (x, A.length);
		Node<Voter> p = A[h];
      while ((p != null) && !(p.getData().getID().trim().equals(x))) {
			p = p.getLink();
      }
		return p;
	}
}
