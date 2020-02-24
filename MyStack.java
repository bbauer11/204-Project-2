import java.util.Vector;

public class MyStack<T> implements StackInterface<T> {

	private Vector<T> vector;
	private int stackSize, actualSize;
	
	public MyStack() {
		this.vector = new Vector<T>();
		actualSize = 0;
		this.stackSize = 10;
	}
	
	public MyStack(int stackSize) {
		this.vector = new Vector<T>(stackSize);
		this.stackSize = stackSize;
		actualSize = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return vector.isEmpty();
	}

	@Override
	public boolean isFull() {
		return actualSize == stackSize ? true : false;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;
		else {
			T v = (T) vector.get(vector.size() - 1);
			vector.removeElementAt(vector.size() - 1);
			actualSize--;
			return v;
		}
	}

	@Override
	public int size() {
		return vector.size();
	}

	@Override
	public boolean push(T e) {
		if (isFull())
			return false;
		else {
			actualSize++;
			return vector.add(e);
		}
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		return (T[]) vector.toArray();
	}

	public T peek() {
		if (vector.size() > 0)
			return vector.get(vector.size() - 1);
		else return null;
	}
	
}
