package alda.linear;

import java.util.Collection;
import java.util.Iterator;

/**
 * This is the list interface you should implement. It is a simplified version
 * of <a href="http://docs.oracle.com/javase/8/docs/api/java/util/Queue.html">
 * java.util.Queue</a> where you will find more documentation for most of the
 * methods.
 * <p>
 * Please note that you should implement all the functionality of the queue on
 * your own using a <em>singly</em> linked list. You may, of course, create
 * temporary linked lists in methods, but you are not allowed to use any arrays,
 * ArrayLists, LinkedLists, Vectors, or other collections anywhere in your code.
 * <p>
 * The test code assumes that the class has a single constructor that takes the
 * capacity of the queue as a parameter.
 * <p>
 * Do NOT rename this interface!
 * 
 * @author Henrik
 */
public interface ALDAQueue<E> extends Iterable<E> {

	public void add(E element);

	public void addAll(Collection<? extends E> c);

	public E remove();

	public E peek();

	public void clear();

	public int size();

	public boolean isEmpty();

	public boolean isFull();

	/**
	 * Set when creating the queue.
	 */
	public int totalCapacity();

	public int currentCapacity();

	/**
	 * Move all elements equal to e to the end of the queue.
	 * 
	 * @param e
	 * @throws NullPointerException
	 *             if e is null.
	 * @return the number of elements moved.
	 */
	public int discriminate(E e);

}
public class ALDAQueueHB<E> implements ALDAQueue<E> {
	
	private int size;
	
	public ALDAQueueHB(int size) {
		this.size = size;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int totalCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int currentCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int discriminate(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

private static class Node<E> {
	E data;
	Node next;
	public Node(E data){
		this.data = data;
	}
}

//HUpoufoidsjflak