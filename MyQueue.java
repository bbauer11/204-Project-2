
public class MyQueue<T> implements QueueInterface<T> {

	private int queueSize, actualSize;
	private Node firstNode, lastNode;
	
	public MyQueue(int size) {
		queueSize = size;
		actualSize = 0;
	}
	
	public MyQueue() {
		queueSize = 10;
		actualSize = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		return firstNode == null && lastNode == null ? true : false;
	}

	@Override
	public boolean isFull() {
		return actualSize >= queueSize ? true : false;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return actualSize;
	}

	@Override
	public boolean enqueue(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	private class Node {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node next() {
			return this.next;
		}
		
		public void setNext(Node n) {
			this.next = n;
		}
		
		public boolean hasNext() {
			return next == null ? false : true;
		}
	}
}
