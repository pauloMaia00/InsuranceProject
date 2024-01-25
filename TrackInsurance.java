package pmaiamod6csc222;

import java.util.*;

public class TrackInsurance {
	public static Scanner scan = new Scanner(System.in);

	// method that runs first
	public static void main(String[] args) throws Exception {

		// make an ArrayList of customers and insurance policies
		ArrayList<Customer> cust = new ArrayList<Customer>();
		// note - the ArrayList below can hold Insurance objects
		// but with inheritance, that includes Auto, Health, Life and Art
		ArrayList<Insurance> ins = new ArrayList<Insurance>();

		// create some fake customers (used for testing the program)
		Customer c = new Customer("Duck", "Donald");
		Customer c1 = new Customer("Mouse", "Minnie");
		Customer c2 = new Customer("Mouse", "Mickey");

		// add the customers to the array list

		cust.add(c2);
		cust.add(c1);
		cust.add(c);

		// make and add some insurance policies to the ArrayList
		ins.add(new AutoInsurance(c, 2));
		ins.add(new AutoInsurance(c1, 3));
		ins.add(new HealthInsurance(c, 5));
		ins.add(new HealthInsurance(c2, 1));
		ins.add(new LifeInsurance(c, 30000, 65));
		ins.add(new LifeInsurance(c1, 400000, 34));
		ins.add(new ArtInsurance(c, "The Starry Night", 400000));
		ins.add(new ArtInsurance(c, "The Last Supper", 390000));
		ins.add(new ArtInsurance(c1, "Mona Lisa", 500000));
		ins.add(new ArtInsurance(c1, "The Scream", 450000));
		ins.add(new ArtInsurance(c2, "Girl with a Pearl Earring", 350000));

		int choice = 0;
		while (choice >= 0) {
			choice = menu();
			if (choice == 1)
				printAllCustomers(cust);
			else if (choice == 2)
				printAllInsurance(ins);
			else if (choice == 3) {
				System.out.println("Now lets find the information for a certain policy number");
				System.out.println("What policy number do you want to find?");
				int num = scan.nextInt();
				printPolicy(ins, num);
			} else if (choice == 4) {
				System.out.println("Now let's find all of the policies for a given customer");
				System.out.println("What is the customer id?");
				int custNum = scan.nextInt();
				getCustomer(ins, custNum);
			} else if (choice == 5)
				sortCustNum(ins);
			else if (choice == 6)
				sortPolNum(ins);
			else if (choice == 7) {
				System.out.println("Bye!!!!!");
				choice = -1;
			}
		} // end while

	}

	public static int menu() {
		System.out.println("Choice:");
		System.out.println("   1.  Print all customers (call the toString method)");
		System.out.println("   2.  Print all insurance information (call the toString method)");
		System.out.println("   3.  Given a policy number, print the policy information");
		System.out.println("   4.  Find all of the policies for a given customer");
		System.out.println("   5.  Sort the insurance policy information by customer number");
		System.out.println("   6.  Sort the insurance policy information by policy number");
		System.out.println("   7. QUIT!! ");
		System.out.println("\n CHOICE:");
		int value = scan.nextInt();
		return value;

	}

	// write a printAllCusts method that prints out the toString method for all
	// of the customers
	public static void printAllCustomers(ArrayList<Customer> cust) {
		for (Customer cu: cust)
			System.out.println(cu.toString());

	}

	// write a printAllInsurance method that prints out the toString method for
	// all of the insurance policies
	public static void printAllInsurance(ArrayList<Insurance> insure) {
		// print out all of the information
		for (Insurance ins : insure)
			System.out.println(ins.toString());
	}

	// write a printPolicy method that prints the information for the policy
	// number
	// passed in or the statement "That policy does not exist" if it is not
	// present
	public static void printPolicy(ArrayList<Insurance> insure, int num) {
		for (Insurance in : insure)
			if (in.policyNumber == num) {
				System.out.println(in.toString());
				System.out.println();
				return;
			}
		System.out.println("*** That policy does not exist. ***");

	}

	public static void getCustomer(ArrayList<Insurance> insure, int num) {
		for (Insurance in : insure)
			if (in.getCustomer().getId() == num) {
				System.out.println(in.toString());
			}
		System.out.println("*** There are no policies for that customer. ***");
	}

	// write a method that sorts the policies by policy number
	// look at the example in the search_sort package
	public static void sortPolNum(ArrayList<Insurance> insure) {
		Collections.sort(insure);
	}

	// write a method that sorts the policies by customer number
	// this one is tougher since you can not use the Collections.sort() method
	// so you need to just slug out some code.
	// Look at the bubble sort from the SortByHand in the search_sort package
	// You will want to do something similar
	// Here is some pseudocode to help
	//

	public static void sortCustNum(ArrayList<Insurance> insure) {

		{

			for (int out = insure.size() - 1; out > 1; out--)
				for (int in = 0; in < out; in++) {
					// get the first insurance policy
					Insurance first = insure.get(in);
					// get the customer from that insurance policy
					// get the customer number from that insurance policy
					int iD1 = insure.get(in).getCustomer().getId();

					// get the second insurance policy
					Insurance second = insure.get(in + 1);
					// get the customer from that insurance policy
					// get the customer number from that insurance policy
					int iD2 = insure.get(in + 1).getCustomer().getId();

					// We want to check to see if the second customer number is
					// less than the first one

					// NOTE: When comparing customer numbers:
					// SortByHand uses Strings so it uses the compareTo()
					// method.
					// We are comparing integers so we can just use <

					// if the second customer number is less than the first one
					// swap the two insurance policies in the original "insure"
					// ArrayList
					// check out the SortByHand to see how to swap.
					if (iD1 > iD2) {
						insure.set(in, second);
						insure.set(in + 1, first);
					}

				}
		}
	}

}