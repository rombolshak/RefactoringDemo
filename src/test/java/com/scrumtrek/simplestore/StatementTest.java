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
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        MovieRental rental = new RegularMovieRental("Star Wars", 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Mickey Mouse"));
    }

    @Test
    public void shouldContainMovieNameWhenCustomerRentedIt()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        MovieRental rental = new RegularMovieRental("Star Wars", 1);
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
        MovieRental rental = new RegularMovieRental("Star Wars", 1);
        Assert.assertEquals(2.0, rental.calculateAmount(), 1e-2);
    }

    @Test
    public void shouldAmountBeCorrectWhenNewReleaseMovieRentedForOneDay()
    {
        MovieRental rental = new NewReleaseMovieRental("qwe", 1);

        Assert.assertEquals(3.0, rental.calculateAmount(), 1e-2);
    }

    @Test
    public void shouldAmountBeCorrectWhenChildrenMovieRentedForOneDay()
    {
        MovieRental rental = new ChildrensMovieRental("qwe", 1);

        Assert.assertEquals(1.5, rental.calculateAmount(), 1e-2);
    }

    @Test
    public void shouldAmountBeCorrectWhenRegularMovieRentedForMoreThanTwoDay()
    {
        MovieRental rental = new RegularMovieRental("qwe", 3);

        Assert.assertEquals(3.5, rental.calculateAmount(), 1e-2);
    }

    @Test
    public void shouldAmountBeCorrectWhenChildrenMovieRentedForMorThanThreeDay()
    {
        MovieRental rental = new ChildrensMovieRental("qwe", 5);

        Assert.assertEquals(3.0, rental.calculateAmount(), 1e-2);
    }

    @Test
    public void shouldFrequentRenterPointsBeSummedWhenSeveralFilmsRented()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        MovieRental rental = new RegularMovieRental("qwe", 5);
        MovieRental rental1 = new RegularMovieRental("asd", 5);
        custMickeyMouse.addRental(rental);
        custMickeyMouse.addRental(rental1);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("You earned 2 frequent renter points"));
    }

    @Test
    public void shouldFrequentRenterPointsBeCorrectWhenNewReleaseRentedForSeveralDays()
    {
        MovieRental rental = new NewReleaseMovieRental("qwe", 5);
        Assert.assertEquals(2, rental.calculateRenterPoints());
    }

    @Test
    public void shouldAmountBeSummedWhenSeveralFilmsRented()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        MovieRental rental = new RegularMovieRental("Qwe", 1);
        MovieRental rental1 = new RegularMovieRental("asd", 1);
        custMickeyMouse.addRental(rental);
        custMickeyMouse.addRental(rental1);

        String statement = custMickeyMouse.statement();

        Assert.assertTrue(statement.contains("Amount owed is 4"));
    }
}
