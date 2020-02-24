
public class VolunteerLine implements VolunteerLineInterface {

	MyQueue<Volunteer> volunteerQueue;

	public VolunteerLine() {
		volunteerQueue = new MyQueue<>();
	}
	
	public VolunteerLine(int size) {
		volunteerQueue = new MyQueue<Volunteer>(size);
	}
	
	@Override
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		if (volunteerQueue.isFull())
			throw new VolunteerException("Volunteer Queue is Full");
		else 
			return volunteerQueue.enqueue(v);
	}

	@Override
	public Volunteer volunteerTurn() throws VolunteerException {
		if (volunteerQueue.isEmpty())
			throw new VolunteerException("Volunteer Queue is Empty.");
		else
			return volunteerQueue.dequeue();
	}

	@Override
	public boolean volunteerLineEmpty() {
		return volunteerQueue.isEmpty();
	}

	@Override
	public Volunteer[] toArrayVolunteer() {
		Object[] temp = volunteerQueue.toArray();
		Volunteer[] toReturn = new Volunteer[volunteerQueue.size()];
		for (int i = 0; i < volunteerQueue.size(); i++) {
			toReturn[i] = (Volunteer) temp[i];
		}
		return toReturn;
	}
	
	public Volunteer getFront() {
		return (Volunteer) volunteerQueue.getFront();
	}

}
