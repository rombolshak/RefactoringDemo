package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Assume;
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

        String statement = custMickeyMouse.Statement();

        Assert.assertTrue(statement.contains("Mickey Mouse"));
    }

    @Test
    public void shouldContainMovieNameWhenCustomerRentedIt()
    {
        Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental = new Rental(movStarWars, 1);
        custMickeyMouse.addRental(rental);

        String statement = custMickeyMouse.Statement();

        Assert.assertTrue(statement.contains("Star Wars"));
    }

    @Test
    public void shouldNotContainMovieNameWhenCustomerDidNotRentIt()
    {
        Customer custMickeyMouse = new Customer("Mickey Mouse");

        String statement = custMickeyMouse.Statement();

        Assert.assertTrue(statement.contains("Amount owed is 0"));
        Assert.assertTrue(statement.contains("You earned 0 frequent renter points"));
    }
}
