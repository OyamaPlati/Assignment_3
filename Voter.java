/**
 * An object of this class represents a voter. A voter has a name and ID.
 * @author Oyama Plati
 */
public class Voter {
	private String name;
	private String ID;
	
	/**
	 * This constructor creates a new voter 
	 */
	public Voter () {
		name = null;
		ID = null;
	}
	
	/**
	 * This constructor creates a new voter with the given name and ID
	 * @param name The name of the voter
	 * @param ID The id of the voter
	 */
	public Voter (String name, String ID) {
		this.name = name;
		this.ID = ID;
	}
	
	/**
	 * This constructor creates a new voter with the same data as given voter
	 * @param original The voter to be copied
	 */
	public Voter (Voter original) {
		if (original != null) {
			name = original.name;
			ID = original.ID;
		}
	}
	
	/**
	 * This subroutine obtains the voter name
	 * @return The name of the voter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This subroutine sets the name of voter to the new name
	 * @param name The name of the voter
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * This subroutine obtains the voter ID
	 * @return The ID of the voter
	 */
	public String getID () {
		return ID;
	}
	
	/**
	 * This subroutine sets the id of the voter to the new id
	 * @param id This ID of the voter
	 */
	public void setID (String id) {
		ID = id;
	}
	
	/**
	 * This subroutine obtains the information of voter
	 */
	public String toString () {
		return (name + " " + ID);
	}
	
	/**
	 * This subroutine obtains the clone of voter
	 * @return A new voter that is a clone
	 */
	public Voter clone () {
		return new Voter (this);
	}
	
	/**
	 * This subroutine checks whether two voters are equals
	 * @param other A voter 
	 * @return True/False
	 */
	public boolean equals (Object other) {
		if (other == null)
			return false;
		else if (getClass() != other.getClass())
			return false;
		else
		{
			Voter otherVoter = (Voter)other;
			return (this.name.equals(otherVoter.name)
			    && this.ID.equals(otherVoter.ID));	
		}
	}
} // End of Voter class
