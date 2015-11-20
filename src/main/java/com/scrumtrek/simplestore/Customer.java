package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<>();

	public Customer(String name) {
		m_Name = name;
	}

    public void addRental(Rental arg){
		m_Rentals.add(arg);
	}

	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + m_Name + "\n";
		
		for(Rental each: m_Rentals) {
			result += getRentalStatement(each);
			totalAmount += getRentalAmount(each);
            frequentRenterPoints += getRenterPoints(each);
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}

    private String getRentalStatement(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + getRenterPoints(each) + "\n";
    }

    private double getRentalAmount(Rental each) {
        switch(each.getMovie().getPriceCode()) {
            case Regular:
                return getRegularMovieRentalAmount(each);

            case NewRelease:
                return getNewReleaseMovieRentalAmount(each);

            case Childrens:
                return getChildrensMovieRentalAmount(each);

            default:
                throw new IllegalArgumentException("Price code");
        }
    }

    private double getChildrensMovieRentalAmount(Rental each) {
        double thisAmount = 1.5;
        if (each.getDaysRented() > 3)
        {
            thisAmount = (each.getDaysRented() - 3) * 1.5;
        }

        return thisAmount;
    }

    private double getNewReleaseMovieRentalAmount(Rental each) {
        return each.getDaysRented() * 3;
    }

    private double getRegularMovieRentalAmount(Rental each) {
        double thisAmount = 2;
        if (each.getDaysRented() > 2)
        {
            thisAmount += (each.getDaysRented() - 2) * 1.5;
        }

        return thisAmount;
    }

    private int getRenterPoints(Rental each) {
		int frequentRenterPoints = 1;

		if ((each.getMovie().getPriceCode() == PriceCodes.NewRelease) && (each.getDaysRented() > 1))
        {
            frequentRenterPoints ++;
        }

		return frequentRenterPoints;
	}
}

