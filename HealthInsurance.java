package pmaiamod6csc222;

// "Extends" means inherit all the methods and fields from Insurance
public class HealthInsurance extends Insurance {

	// create a new field called numDependents which is an integer
	private int numDependents;

	// creat a full constructor for a new object. Make certain it sets the rate
	public HealthInsurance(Customer cust, int dependents) {
		super(cust);
		numDependents = dependents;
		calcRate();
	}

	// full constructor if read from a file
	public HealthInsurance(Customer cust, int polNum, double yrRate, int numD) {
		super(cust, polNum, yrRate);
		numDependents = numD;

	}

	// empty constuctor
	public HealthInsurance() {
	}

	// required to make a complete class since we inherited from Insurance that had
	// this method abstract
	public void calcRate() {
		yearlyRate = 500 * numDependents;
	}

	// toString method. First call the one from the super class (Insurance) to write
	// those fields
	// and add on the new fields for this class
	// we override the toString method from the Insurance class
	public String toString() {
		String ans = super.toString();
		return ans + (" for health insurnace. The number of dependents is " + numDependents + ".");
	}

	public int getNumDependents() {
		return numDependents;
	}

	public void setNumDependents(int numDependents) {
		this.numDependents = numDependents;
	}

}
