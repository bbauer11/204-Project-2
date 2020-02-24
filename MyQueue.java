
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
		if (!isEmpty()) {
			actualSize--;
			T toReturn = firstNode.getData();
			firstNode = firstNode.next;
			if (actualSize == 0)
				lastNode = null;
			return toReturn;
		} else
			return null;
	}

	@Override
	public int size() {
		return actualSize;
	}

	@Override
	public boolean enqueue(T newEntry) {
		Node newNode = new Node(newEntry);
		
		if (!isFull()) {
			if (isEmpty())
				firstNode = newNode;
			else 
				lastNode.setNext(newNode);
			
			lastNode = newNode;
			actualSize++;
			return true;
		} else 
			return false;
	}

	@SuppressWarnings("unchecked")   // for generic array creation
	@Override
	public T[] toArray() {
		T[] toReturn = (T[]) new Object[actualSize];
		Node curr = firstNode; 	
		
		for (int i = 0; i < actualSize; i++) {
			toReturn[i] = curr.getData();
			if (curr.hasNext())
				curr = curr.next;
		}
		
		return toReturn;
	}
	
	public T getFront() {
		return firstNode.getData();
	}

	
	
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data) {
			this.data = data;
		}
		
		
		public void setNext(Node n) {
			this.next = n;
		}
		
		public boolean hasNext() {
			return next == null ? false : true;
		}
		
		public T getData() {
			return data;
		}
	}
}
