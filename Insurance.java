package pmaiamod6csc222;

import java.text.*;

// note that this is an abstract class (see p455 of your text)
// I do not want any one to create a generic Insurance instance
// (we only sell Auto, Life, and Health) but so as not to repeat
// common fields in those , we move them up one hierarchy level
// and make a generic Inurance class
/**
 * implements the interface Comparable so I can define how to order or sort
 * Insurance objects
 **/
public abstract class Insurance implements Comparable<Insurance> {
	/**
	 * NOTE: these fields are protected. In order to inherit these , they must be
	 * protected (private allows NO other classes to use them) - protected means
	 * this class and any class that inherits from this one can use these
	 **/
	protected Customer customer;
	protected double yearlyRate;
	protected int policyNumber;
	/**
	 * for currency output
	 **/
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	/**
	 * a static variable used to make the insurance id unique
	 **/

	public static int num = 1000;

	/**
	 * This constructor initializes the object with a customer name, and sets a
	 * unique id
	 * 
	 * @param cust customer name
	 **/
	public Insurance(Customer cust) {
		customer = cust;
		policyNumber = num;
		num++;

	}

	// used for reading from a file where policy number and rate already set
	/**
	 * This constructor initializes the object with a customer name, a policy
	 * number, and a yearly rate
	 * 
	 * @param cust
	 * @param polNum
	 * @param yrRate
	 */
	public Insurance(Customer cust, int polNum, double yrRate) {
		customer = cust;
		policyNumber = polNum;
		yearlyRate = yrRate;

	}

	/**
	 * the empty constructor but still sets a unique id
	 */
	public Insurance() {
		policyNumber = num;
		num++;
	}

	/**
	 * calcRate method is used to set the yearlyRate NOTE: this is an abstract
	 * class. That means it can not be used (has no body) but by putting here, we
	 * require any class that inherits from the Insurance class to fully implement
	 * this method if they want to be a concrete class
	 **/
	public abstract void calcRate();

	/**
	 * toString method. Note - we let the customer write them self out since they
	 * have their own toString method a class should only write out their fields in
	 * the toString method
	 * 
	 * @return customer toString() method with unique id and yearly rate.
	 **/
	public String toString() {
		return (customer.toString() + " with policy number " + policyNumber + " has a yearly rate of "
				+ currency.format(yearlyRate));
	}

	// getters and setters
	/**
	 * The getCustomer method returns the customer name
	 * 
	 * @return customer name.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * The getPolicyNumber method returns the id
	 * 
	 * @return id number.
	 */
	public int getPolicyNumber() {
		return policyNumber;
	}

	/**
	 * The getYearlyRate method returns the yearly rate
	 * 
	 * @return yearly rate.
	 */
	public double getYearlyRate() {
		return yearlyRate;
	}

	/**
	 * The setCustomer method sets the customer
	 * 
	 * @param The customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * The setPolicyNumber method sets the id number
	 * 
	 * @param The id number
	 */
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	/**
	 * The setCustomer method sets the yearly rate
	 * 
	 * @param The yearly rate
	 */
	public void setYearlyRate(double yearlyRate) {
		this.yearlyRate = yearlyRate;
	}

	/**
	 * required by the Comparable interface. Describes how to compare two Insurance
	 * instances In this one, we want to compare policy numbers
	 **/

	public int compareTo(Insurance ins) {
		if (this.policyNumber > ins.policyNumber)
			return 1;
		else if (this.policyNumber == ins.policyNumber)
			return 0;
		else
			return -1;

	}

}
