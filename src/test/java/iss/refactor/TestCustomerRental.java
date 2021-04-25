package iss.refactor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestCustomerRental {
	@Test
	public void TestGetName() {
		CustomerRental cr = new CustomerRental("test");
		assertEquals("test", cr.getName());
	}
	
	@Test
	public void TestAddRental() {
		Rental mockRental = Mockito.mock(Rental.class);
		
		CustomerRental cr = new CustomerRental("test");
		cr.addRental(mockRental);
		
		assertEquals(1, cr.totalRented());
	}
	
	@Test
	public void testStatementForRegularMovie1() {
		testStatementForRegularMovie(1, 2);
	}
	
	@Test
	public void testStatementForRegularMovie2() {
		testStatementForRegularMovie(2, 2);
	}
	
	@Test
	public void testStatementForRegularMovie3() {
		testStatementForRegularMovie(3, 3.5);
	}
	
	@Test
	public void testStatementForRegularMovie4() {
		testStatementForRegularMovie(4, 5);
	}
	
	public void testStatementForChildrenMovie(int daysRented, double expectedOwed) {
		testStatement(Movie.CHILDRENS, daysRented, expectedOwed, 1);
	}
	
	@Test
	public void testStatementForChildrenMovie1() {
		testStatementForChildrenMovie(1, 1.5);
	}
	
	@Test
	public void testStatementForChildrenMovie2() {
		testStatementForChildrenMovie(3, 1.5);
	}
	
	@Test
	public void testStatementForChildrenMovie3() {
		testStatementForChildrenMovie(4, 3);
	}
	
	@Test
	public void testStatementForChildrenMovie4() {
		testStatementForChildrenMovie(5, 4.5);
	}
	
	public void testStatementForRegularMovie(int daysRented, double expectedOwed) {
		testStatement(Movie.REGULAR, daysRented, expectedOwed, 1);
	}
	
	@Test
	public void testStatementForNewReleaseMovie1() {
		testStatementForNewReleaseMovie(1, 3, 1);
	}
	
	@Test
	public void testStatementForNewReleaseMovie2() {
		testStatementForNewReleaseMovie(2, 6, 2);
	}
	
	@Test
	public void testStatementForNewReleaseMovie3() {
		testStatementForNewReleaseMovie(3, 9, 2);
	}
	
	public void testStatementForNewReleaseMovie(int daysRented, double expectedOwed, int expectedFrequentPoints) {
		testStatement(Movie.NEW_RELEASE, daysRented, expectedOwed, expectedFrequentPoints);
	}
	
	
	public void testStatement(int movieCategory, int daysRented, double expectedOwed, int expectedFrequentPoints) {
		String customerName = "Alex Tan";
		CustomerRental cr = new CustomerRental(customerName);
		
		String movieName1 = "Journey to the West";
		Movie mv1 = new Movie(movieName1, movieCategory);
		Rental rental1 = new Rental(mv1, daysRented);
		
		cr.addRental(rental1);
		
		String expected = "Rental Record for " + customerName + "\n";
		expected += "\t" + movieName1 + "\t" + expectedOwed + "\n";
		
		expected += "Amount owed is " + expectedOwed + "\n";
		
		expected += "You earned " + expectedFrequentPoints + " frequent renter points";
		
//		System.out.println(expected);
//		System.out.println(cr.statement());
		
		assertEquals(expected, cr.statement());
	}
	
	
	@Test
	public void testStatement2() {
		String customerName = "Alex Tan";
		CustomerRental cr = new CustomerRental(customerName);
		
		String movieName1 = "Journey to the West";
		Movie mv1 = new Movie(movieName1, Movie.REGULAR);
		Rental rental1 = new Rental(mv1, 2);
		double amountOwn1 = 2;
		
		String movieName2 = "Alice in the Wonderland";
		Movie mv2 = new Movie(movieName2, Movie.CHILDRENS);
		Rental rental2 = new Rental(mv2, 3);
		double amountOwn2 = 1.5;
		
		cr.addRental(rental1);
		cr.addRental(rental2);
			
		String expected = "Rental Record for " + customerName + "\n";
		expected += "\t" + movieName1 + "\t" + amountOwn1 + "\n";
		expected += "\t" + movieName2 + "\t" + amountOwn2 + "\n";
		
		expected += "Amount owed is " + (amountOwn1+ amountOwn2) + "\n";
		
		int expectFrequentRenterPoints = 2;
		expected += "You earned " + expectFrequentRenterPoints + " frequent renter points";
		
		System.out.println(expected);
		System.out.println(cr.statement());
		
		assertEquals(expected, cr.statement());
	}
	
}
