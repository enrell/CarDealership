package cardealership;

import java.util.NoSuchElementException;

public class PriorityQueue {
	private class Node {
		private Person person;
		private int priority;
		private Node next;

		public Node(Person person, int priority) {
			this.person = person;
			this.priority = priority;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	public PriorityQueue() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return size;
	}

	public void enqueue(Person person, int ticketNumber) {
		int priority = person.isElderly() ? 0 : ticketNumber;

		Node newNode = new Node(person, priority);

		if (isEmpty() || priority < front.priority) {
			newNode.next = front;
			front = newNode;
		} else {
			Node current = front;
			while (current.next != null && current.next.priority <= priority) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}

		if (rear == null) {
			rear = front;
		}

		size++;
	}

	public Person dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty.");
		}

		Person removedPerson = front.person;
		front = front.next;
		size--;

		if (isEmpty()) {
			rear = null;
		}

		return removedPerson;
	}

	public void displayQueueSize() {
		System.out.println("Queue size: " + size);
	}
}
