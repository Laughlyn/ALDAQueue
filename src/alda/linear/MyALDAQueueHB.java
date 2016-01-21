package alda.linear;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyALDAQueueHB<E> implements ALDAQueue<E> {

	private static class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
		}

		// public Node(E data, Node<E> next) {
		// this.next = next;
		// }
	}

	private Node<E> first;
	private Node<E> last;
	private int totCapacity;
	private int capacity;

	public MyALDAQueueHB(int capacity) {
		if (capacity < 1)
			throw new IllegalArgumentException("Can't be smaller than 1!");
		else
			this.capacity = capacity;
		this.totCapacity = capacity;
	}

	@Override
	public Iterator<E> iterator() {
		if (isEmpty()) {
			return new MyALDAQueueHBIterator();
		} else {
			return new MyALDAQueueHBIterator();
		}
	}

	private class MyALDAQueueHBIterator implements Iterator<E> {
		private Node<E> current = null;

		@Override
		public boolean hasNext() {
			return current != last;
		}

		@Override
		public E next() {
			if (current == null) {
				current = first;
				return current.data;
			}
			if (current.next == null) {
				throw new NoSuchElementException();
			}
			current = current.next;
			return current.data;
		}
	}

	@Override
	public void add(E element) {
		if (element == null)
			throw new NullPointerException();
		else if (this.size() >= totCapacity) {
			throw new IllegalStateException();
		} else {
			if (first == null) {
				first = new Node<E>(element);
				last = first;
				capacity--;
			} else {
				last.next = new Node<E>(element);
				last = last.next;
				capacity--;
			}
		}
	}

	@Override
	public void addAll(Collection<? extends E> c) {
		for (E e : c) {
			this.add(e);
		}
	}

	@Override
	public E remove() {
		Node<E> temp = null;
		if (last != first) {
			temp = first;
			first = first.next;
			capacity++;
			return temp.data;
		} else if (last == first && first != null) {
			temp = first;
			first = null;
			last = null;
			capacity++;
			return temp.data;
		} else {
			throw new NoSuchElementException();
		}

	}

	@Override
	public E peek() {
		if (first != null)
			return first.data;
		else
			return null;
	}

	@Override
	public void clear() {
		first = null;
		last = first;
		capacity = totCapacity;
	}

	@Override
	public int size() {
		int size = 0;
		for (Node<E> temp = first; temp != null; temp = temp.next) {
			size++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (first == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if (this.size() == totCapacity)
			return true;
		else
			return false;
	}

	@Override
	public int totalCapacity() {
		return totCapacity;
	}

	@Override
	public int currentCapacity() {
		return capacity;
	}

	// @Override
	// public int discriminate(E e) {
	// int matches = 0;
	// MyALDAQueueHB<E> tempQ = new MyALDAQueueHB<E>(totCapacity);
	// Iterator<E> iter = this.iterator();
	// for (E ee : this) {
	// if(ee == e) {
	// matches++;
	// if(iter.hasNext()) {
	// first = first.next;
	// capacity++;
	// tempQ.add(e);
	// }
	// }
	// }
	// for (E ee : tempQ) {
	// this.add(ee);
	// }
	// return matches;
	// }

	@Override
	public int discriminate(E e) {
		if (e == null) {
			throw new NullPointerException();
		} else {
			int matches = 0;
			MyALDAQueueHB<E> tempQ = new MyALDAQueueHB<E>(totCapacity);
			MyALDAQueueHB<E> tempQ2 = new MyALDAQueueHB<E>(totCapacity);
			MyALDAQueueHBIterator iter = new MyALDAQueueHBIterator();
			while (iter.hasNext()) {
				if (iter.next() == e) {
					matches++;
					if (iter.current == first) {
						first = first.next;
						capacity++;
						tempQ.add(iter.current.data);
					}
				} else {
					first = first.next;
					capacity++;
					tempQ2.add(iter.current.data);
				}
			}
			for (E ee : tempQ2) {
				this.add(ee);
			}
			for (E ee : tempQ) {
				this.add(ee);
			}
			return matches;
		}
	}

	public String toString() {
		if (size() == 0)
			return "[]";
		String str = "[";
		for (Node<E> temp = first; temp != null; temp = temp.next) {
			str += temp.data;
			if (temp != last)
				str += ", ";
		}
		str += "]";
		return str;
	}

}