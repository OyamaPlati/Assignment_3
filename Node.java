/**
 * An object of this class represents a node.
 * @author Oyama Plati
 * @param <T> Any class type
 */
public class Node<T>
{
	private T data;
	private Node<T> link;
	
	/**
	 * This constructor creates a new node
	 */
	public Node ()
	{
		data = null;
		link = null;
	}
	
	/**
	 * This constructor creates a new node with the given data and link
	 * @param newData The object type
	 * @param linkValue The object link value
	 */
	public Node (T newData, Node<T> linkValue)
	{
		data = newData;
		link = linkValue;
	}
	
	/**
	 * This subroutine obtains the link to the next node
	 * @return This link to the next node
	 */
	public Node<T> getLink () {
		return link;
	}
	
   /**
    * This subroutine sets the link to new node
    * @param The next node
    */
   public void setLink (Node<T> node) {
      link = node;
   }
   
	/**
	 * This subroutine obtains the data of the node
	 * @return The data contained in the node
	 */
	public T getData () {
		return data;
	}
	
   /**
    * This subroutine sets the data of the node 
    * @param The data for capsule
    */
   public void setData (T data) {
      this.data = data; 
   }
   
}//End of Node<T> class

	