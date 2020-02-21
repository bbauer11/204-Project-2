
public class Container implements ContainerInterface {

	private MyStack<DonationPackage> packageStack;
	
	public Container() {
		packageStack = new MyStack<DonationPackage>();
	}
	
	public Container(int size) {
		packageStack = new MyStack<DonationPackage>();
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
		return packageStack.toArray();
	}
}
