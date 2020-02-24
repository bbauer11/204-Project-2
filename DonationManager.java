
public class DonationManager implements DonationManageInterface {

	Container container;
	VolunteerLine volunteerLine;
	RecipientLine recipientLine;
	
	public DonationManager() {
		container = new Container();
		volunteerLine = new VolunteerLine();
		recipientLine = new RecipientLine();
	}
	
	@Override
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException {
		return container.loadContainer(dPackage);
	}

	@Override
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return volunteerLine.addNewVolunteer(v);
	}

	@Override
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return recipientLine.addNewRecipient(r);
	}

	@Override
	public int donatePackage() throws VolunteerException, ContainerException, RecipientException {
		if (container.isEmpty())
			throw new ContainerException("Contain is Empty.");
		else if (volunteerLine.volunteerLineEmpty())
			throw new VolunteerException("Volunteer Queue is Empty.");
		else if (recipientLine.recipientLineEmpty())
			throw new RecipientException("Recipient Queue is Empty.");
		else {
			container.removePackageFromContainer();
			volunteerLine.addNewVolunteer(volunteerLine.volunteerTurn());
			recipientLine.recipientTurn();
		}
		
		return 0;  // this return value should not make a difference anyways. 
	}

	@Override
	public DonationPackage[] managerArrayPackage() {
		return container.toArrayPackage();
	}

	@Override
	public Volunteer[] managerArrayVolunteer() {
		return volunteerLine.toArrayVolunteer();
	}

	@Override
	public Recipient[] managerArrayRecipient() {
		return recipientLine.toArrayRecipient();
	}

	public String toString() {
		return volunteerLine.toArrayVolunteer()[0].getName() + "donated a " + container.toArrayPackage()[0].getDescription() + " package to " + recipientLine.toArrayRecipient()[0].getName();
	}

}
