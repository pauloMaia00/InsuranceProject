package pmaiamod6csc222;

import java.text.NumberFormat;

// "extends" means inherits methods and fields from the Insurance class
public class LifeInsurance extends Insurance 
 {
	// declare two new fields added - the amount of insurance they want (amount - an integer) and their age (age - an integer )
	private int amount;
	private int age;
	// full constructor.  Let super (Insurance) set any fields that really came from there.
	// Make certain to also set the rate
	public LifeInsurance (Customer cust,int amtIns, int custAge)
	{
		super(cust);
		this.amount = amtIns;
		this.age = custAge;
		calcRate();
	}		
	
	// empty constructor
	public LifeInsurance ()
	{
	}
	
	// full constructor if reading from a file
	public LifeInsurance (Customer cust, int polNum, double yrRate, int amtIns, int custAge)
	{
		super(cust,polNum,yrRate);
		this.amount = amtIns;
		this.age = custAge;
			
	}
	
	// required to write this if this class is to be a real class - fulfills the abstract requirements
	public  void calcRate()
	{
		if (age>40)
			yearlyRate = amount*.005*2;
		else
			yearlyRate = amount*.005;
	}
	
	// to String.  Let the Insurance class print out its fields and let this class print out new fields
//	we override the toString method from the Insurance class
	public String toString ()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String ans = super.toString();
		return  ans + (" for life insurance. The amount of insurance wanted is " + currency.format(amount) + " and age of customer is " + age + ".");
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

