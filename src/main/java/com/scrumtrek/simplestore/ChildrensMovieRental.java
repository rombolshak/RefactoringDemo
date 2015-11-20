package com.scrumtrek.simplestore;

public class ChildrensMovieRental extends MovieRental {
	public ChildrensMovieRental(String title, int rentedDays) {
		super(title, rentedDays);
	}

	@Override
	public double calculateAmount() {
		double thisAmount = 1.5;
		if (m_DaysRented > 3)
		{
			thisAmount = (m_DaysRented - 3) * 1.5;
		}

		return thisAmount;
	}
}
