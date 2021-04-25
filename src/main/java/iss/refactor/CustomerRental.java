package iss.refactor;

import java.util.ArrayList;
import java.util.List;

public class CustomerRental {
	private String _name;
	private List<Rental> _rentals = new ArrayList<>();
	
	public CustomerRental(String name) {
		_name = name;
	}
	
	public String getName() {
		return _name;
	}
	
	public int totalRented() {
		return _rentals.size();
	}
	
	public void addRental(Rental rental) {
		_rentals.add(rental);
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		String result = "Rental Record for " + getName() + "\n";
		for (Rental rental: _rentals) {
			double thisAmount = 0;
			
			// determine amounts for each line
			switch (rental.getMovie().getCategory()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (rental.getDaysRented() > 2) {
					thisAmount += (rental.getDaysRented() - 2) * 1.5;
				}
				break;
				
			case Movie.NEW_RELEASE:
				thisAmount += rental.getDaysRented() * 3;
				break;
			
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (rental.getDaysRented() > 3)
					thisAmount += (rental.getDaysRented() - 3) * 1.5;
				break;
			} // end switch
			
			frequentRenterPoints++;
			
			// add bonus for a two day new release rental
			if ((rental.getMovie().getCategory() == Movie.NEW_RELEASE) 
					&& rental.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
			
			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
						+ thisAmount + "\n";
			
			totalAmount += thisAmount;
		}
		
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		
		return result;
	}

}
