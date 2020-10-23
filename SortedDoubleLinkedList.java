import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	protected Comparator<T> comparator = null;
	
	/**
	 * Constructor - Creates an empty list that is associated with the specified comparator.
	 * @param comparator2 - Comparator to compare data elements
	 */
	
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}
	
	/**
	 * Implements the iterator by calling the super class iterator metelementd.
	 * @return an iterator positioned at the head of the list
	 * @throws UnsupportedOperationException, NoSuchElementException
	 */
	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
	        return super.iterator();
	    }
	
	/**
	 * Implements the remove operation by calling the super class remove metelementd.
	 * @return data element or null
	 * @param data - data element to remove
	 * @param comparator - the comparator to determine equality of data elements
	 */
	@Override
	public SortedDoubleLinkedList<T> remove (T data, Comparator<T> comparator) {
	        super.remove(data, comparator);
	        return this;
	    }
	
	/**
	 * This operation is invalid for a sorted list. 
	 * @param data - data to be added
	 * @throws UnsupportedOperationException
	 */
	@Override 
	public BasicDoubleLinkedList<T> addToFront(T data) {
	        throw new UnsupportedOperationException("Invalid operation for sorted list");
	    }
	 
	/**
	 * This operation is invalid for a sorted list
	 * @param data - data to be added
	 * @throws UnsupportedOperationException
	 */
	@Override
	 public BasicDoubleLinkedList<T> addToEnd(T data) {
	        throw new UnsupportedOperationException( "Invalid operation for sorted list");
	    }
	 
	 
	    
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 *  Notice we can insert the same element several times. 
	 *  Your implementation must traverse the list only once in order to perform the insertion. 
	 *  Do not implement this metelementd using iterators.
	 *   Notice that you don't need to call any of the super class metelementds in order to implement this metelementd.
	 * @param data - the data to be added
	 * @return a reference to the current object
	 */
	
	 public SortedDoubleLinkedList<T> add(T data){
		Node element = new Node(data);
        
        if (size == 0) {
            head = tail = element;
        }else if (comparator.compare(tail.data, data) < 0) {
            tail.next = element;
            element.previous = tail;
            tail = element;
            }
        else if (comparator.compare(head.data, data) > 0) {
            head.previous = element;
            element.next = head;
            head = element;
       
        } else {
            Node current = head;
            while (current != null) {
                if (comparator.compare(current.data, data) <= 0) {
                    Node before = current;
                    Node after = current.next;
                    after.previous = before.next = element;
                    element.next = after;
                    element.previous = before;   
                }
                current = current.next;
            }
        }
        size++;
        return this;
    }	
	
	
}
