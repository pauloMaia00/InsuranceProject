package pmaiamod6csc222;

import java.text.NumberFormat;

public class ArtInsurance extends Insurance {

	private String description;
	private double value;

	public ArtInsurance(Customer cust, String description, double value) {

		super(cust);
		this.description = description;
		this.value = value;
		calcRate();
	}

	public ArtInsurance() {

	}

	public ArtInsurance(Customer cust, int polNum, double yrRate, String description, double value) {
		super(cust, polNum, yrRate);
		this.description = description;
		this.value = value;
	}

	public void calcRate() {

		if (value > 400000)
			yearlyRate = 125000;
		else
			yearlyRate = 50000;
	}

	public String toString() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String ans = super.toString();

		return ans + (" for art insurance. The art work is " + description + ", and the value is "
				+ currency.format(value) + ".");
	}

}
