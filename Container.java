
public class Container implements ContainerInterface {

	private MyStack<DonationPackage> packageStack;
	
	public Container() {
		packageStack = new MyStack<DonationPackage>();
	}
	
	public Container(int size) {
		packageStack = new MyStack<DonationPackage>(size);
	}
	
	
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if (packageStack.isFull())
			throw new ContainerException("The Container is Full.");
		else 
			return packageStack.push(dPackage);
	}
	
	
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if (packageStack.isEmpty()) 
			throw new ContainerException("The Container is Empty.");
		else
			return packageStack.pop();
	}
	
	public DonationPackage[] toArrayPackage() {
		
		Object[] temp = packageStack.toArray(); 
		DonationPackage[] toReturn = new DonationPackage[packageStack.size()];
		for (int i = 0; i <	packageStack.size(); i++) {
			toReturn[i] = (DonationPackage) temp[i]; 
		}
		return toReturn;
	}
	
	public boolean isEmpty() {
		return packageStack.isEmpty();
	}
	
	public DonationPackage getTop() {
		if (packageStack.isEmpty())
			return (DonationPackage) packageStack.peek();
		else
			return null;
	}
}
