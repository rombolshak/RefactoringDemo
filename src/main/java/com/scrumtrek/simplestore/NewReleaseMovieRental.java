package com.scrumtrek.simplestore;

public class NewReleaseMovieRental extends MovieRental {
	public NewReleaseMovieRental(String title, int rentedDays) {
		super(title, rentedDays);
	}

	@Override
	public double calculateAmount() {
		return m_DaysRented * 3;
	}

	@Override
	public int calculateRenterPoints()
	{
		int points = super.calculateRenterPoints();
		if (m_DaysRented > 1) {
			points += 1;
		}

		return points;
	}
}
