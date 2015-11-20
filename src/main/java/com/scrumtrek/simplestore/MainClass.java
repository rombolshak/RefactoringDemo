package com.scrumtrek.simplestore;

class MainClass {
	 static void Main(String[] args) {
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		MovieRental rental1 = new RegularMovieRental("qwe", 5);
		MovieRental rental2 = new ChildrensMovieRental("asd", 5);
		MovieRental rental3 = new NewReleaseMovieRental("zxc", 65);

		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		String statement = custMickeyMouse.statement();

		System.out.println(statement);		
	}
}

