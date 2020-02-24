
public class RecipientLine implements RecipientLineInterface {

	MyQueue<Recipient> recipientQueue;
	
	public RecipientLine() {
		recipientQueue = new MyQueue<>();
	}
	
	public RecipientLine(int size) {
		recipientQueue = new MyQueue<>(size);
	}
	
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		if (recipientQueue.isFull())
			throw new RecipientException("Recipient Queue is Full.");
		else 
			return recipientQueue.enqueue(rc);
		
	}
	
	public Recipient recipientTurn() throws RecipientException {
		if (recipientQueue.isEmpty())
			throw new RecipientException("Recipient Queue is Empty.");
		else
			return recipientQueue.dequeue();
		
	}
	
	public boolean recipientLineEmpty() {
		return recipientQueue.isEmpty();
	}
	
	public Recipient[] toArrayRecipient() {
		Object[] temp = recipientQueue.toArray();
		Recipient[] toReturn = new Recipient[recipientQueue.size()];
		for (int i = 0; i < recipientQueue.size(); i++) {
			toReturn[i] = (Recipient) temp[i];
		}
		return toReturn;
	}
	
	public Recipient getFront() {
		return (Recipient) recipientQueue.getFront();
	}
}
