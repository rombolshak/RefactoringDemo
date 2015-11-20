package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by roma on 19.11.15.
 */
public class StatementTest {

    @Test
    public void shouldContainCustomerNameWhenCustomerStatementRequested()
    {
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Mickey Mouse"));
    }

    @Test
    public void shouldContainMovieNameWhenCustomerRentedIt()
    {
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Star Wars"));
    }

    @Test
    public void shouldNotContainMovieNameWhenCustomerDidNotRentIt()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 0"));
        Assert.assertTrue(statement.contains("You earned 0 frequent renter points"));
    }

    @Test
    public void shouldAmountBeCorrectWhenRegularMovieRentedForOneDay()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 2"));
    }

    @Test
    public void shouldAmountBeCorrectWhenNewReleaseMovieRentedForOneDay()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.NewRelease);
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 3"));
    }

    @Test
    public void shouldAmountBeCorrectWhenChildrenMovieRentedForOneDay()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Childrens);
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 1.5"));
    }

    @Test
    public void shouldAmountBeCorrectWhenRegularMovieRentedForMoreThanTwoDay()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Rental rental = new Rental(movStarWars, 3);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 3.5"));
    }

    @Test
    public void shouldAmountBeCorrectWhenChildrenMovieRentedForMorThanThreeDay()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Childrens);
        Rental rental = new Rental(movStarWars, 5);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 3"));
    }

    @Test
    public void shouldFrequentRenterPointsBeSummedWhenSeveralFilmsRented()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Childrens);
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Rental rental = new Rental(movStarWars, 5);
        Rental rental1 = new Rental(movCinderella, 5);
        custMickeyMouse.addRental(rental);
        custMickeyMouse.addRental(rental1);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("You earned 2 frequent renter points"));
    }

    @Test
    public void shouldFrequentRenterPointsBeCorrectWhenNewReleaseRentedForSeveralDays()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Movie movStarWars = new Movie("Star Wars", PriceCodes.NewRelease);
        Rental rental = new Rental(movStarWars, 5);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("You earned 2 frequent renter points"));
    }
}
