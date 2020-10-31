package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.size = 0;
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("The element can't have a null value");
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		if(index < 0) {
			throw new IndexOutOfBoundsException("Not a valid index!!!");
		}
		LLNode<E> currentNode = head.next;
		for(int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		if(currentNode.data == null) {
			throw new IndexOutOfBoundsException("can't add null elements");
		}
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newHolder = new LLNode<E>(element);
		if(element == null) {
			throw new NullPointerException("The element can't have a null value");
		}
		if(index<0) {throw new IndexOutOfBoundsException("Index "+
				index+" is out of bounds");}
		if(index >= size && index != 0) {throw new IndexOutOfBoundsException("Index "+
				index+" is out of bounds");}
		LLNode<E> holder = head;
		for(int i = 0; i <= index; i++) { // select the original node at the designated index.
			holder = holder.next;
		}
		newHolder.prev = holder.prev;
		holder.prev.next = newHolder;
		newHolder.next = holder;
		holder.prev = newHolder;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index >= size || index<0) {throw new IndexOutOfBoundsException("Index "+
				index+" is out of bounds");}
		LLNode<E> holder = head;
		for(int i = 0; i <= index; i++) { // select the original node at the designated index.
			holder = holder.next;
		}
		holder.next.prev = holder.prev;
		holder.prev.next = holder.next;
		holder.next = null;
		holder.prev = null;
		size--;
		return holder.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index >= size || index<0) {throw new IndexOutOfBoundsException("Index "+
				index+" is out of bounds");}
		if(element == null) {
			throw new NullPointerException("The element can't have a null value");
		}
		LLNode<E> holder = head;
		for(int i = 0; i <= index; i++) { // select the original node at the designated index.
			holder = holder.next;
		}
		E originalData = holder.data;
		holder.data = element;
		return originalData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
