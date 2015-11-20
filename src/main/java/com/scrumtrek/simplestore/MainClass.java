package com.scrumtrek.simplestore;

class MainClass {
	 static void Main(String[] args) {
		Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
		Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
		Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		String statement = custMickeyMouse.statement();

		System.out.println(statement);		
	}
}

