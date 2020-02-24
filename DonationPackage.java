
public class DonationPackage {

	private String description;
	private double weight;
	
	public DonationPackage(String description, double weight) {
		this.description = description;
		this.weight = weight;
	}

	public boolean isHeavy() {
		return weight < 20 && weight > 0 ? false : true;
	}

	public String getDescription() {
		return description;
	}

	//used in tests and gui
	public String toString() {
		return description;
	}
}
