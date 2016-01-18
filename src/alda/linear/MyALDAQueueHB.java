package alda.linear;

import java.util.Collection;
import java.util.Iterator;

public class MyALDAQueueHB<E> implements ALDAQueue<E> {

	private static class Node<E> {
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
		}

		public Node(E data, Node next) {
			this.next = next;
		}
	}

	private Node<E> first;
	private Node<E> last;
	private int capacity;

	public MyALDAQueueHB(int capacity) {
		if (capacity <1)
			throw new IllegalArgumentException("Can't be smaller than 1!");
		else
		this.capacity = capacity;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E element) {
		if (first == null) {
			first = new Node<E>(element);
			last = first;
		}
		else {
			last.next = new Node<E>(element);
			last = last.next;
		}
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
		return this.capacity;
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