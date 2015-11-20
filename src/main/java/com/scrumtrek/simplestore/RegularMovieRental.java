package com.scrumtrek.simplestore;

public class RegularMovieRental extends MovieRental {
	public RegularMovieRental(String title, int rentedDays) {
		super(title, rentedDays);
	}

	@Override
	public double calculateAmount() {
		double thisAmount = 2;
		if (m_DaysRented > 2)
		{
			thisAmount += (m_DaysRented - 2) * 1.5;
		}

		return thisAmount;
	}
}
