package com.scrumtrek.simplestore;

public abstract class MovieRental {
	protected int m_DaysRented;
	private String m_Title;

	public MovieRental(String movieTitle, int daysRented) {
		m_DaysRented = daysRented;
		m_Title = movieTitle;
	}

	public String getTitle() {
		return m_Title;
	}

	public abstract double calculateAmount();
	public int calculateRenterPoints()
	{
		return 1;
	}
}

