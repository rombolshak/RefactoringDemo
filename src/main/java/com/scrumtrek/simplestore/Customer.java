package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<MovieRental> m_Rentals = new ArrayList<>();

	public Customer(String name) {
		m_Name = name;
	}

    public void addRental(MovieRental arg){
		m_Rentals.add(arg);
	}

	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + m_Name + "\n";
		
		for(MovieRental each: m_Rentals) {
			result += getRentalStatement(each);
			totalAmount += each.calculateAmount();
            frequentRenterPoints += each.calculateRenterPoints();
		}

		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}

    private String getRentalStatement(MovieRental each) {
        return "\t" + each.getTitle() + "\t" + each.calculateRenterPoints() + "\n";
    }
}

