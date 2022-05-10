package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import shopping.Item;


public class TestClass {
	
	Item item1 = new Item("1 book at 12.49", true);
	Item item2 = new Item("1 music CD at 14.99", false);
	Item item3 = new Item("1 chocolate bar at 0.85", true);
	Item item4 = new Item("1 imported box of chocolates at 10.00", true);
	Item item5 = new Item("1 imported bottle of perfume at 47.50", false);
	Item item6 = new Item("1 bottle of perfume at 18.99", false);
	
	@Test
	@DisplayName("Getter/Setter_Test")
	public void testGetSet() {
		assertEquals("book", item1.getName());
		assertEquals("book", item1.getType());
		assertEquals(12.49, item1.getPrice());
		assertEquals(false, item1.isImported());
	}
	
	@Test
	@DisplayName("Tax_calculation")
	public void testTaxCalc() {
		assertEquals(12.49, item1.getTaxPrice());
		assertEquals(0, item1.getTax());
		assertEquals(16.49, item1.getTaxPrice());
		assertEquals(1.50, item1.getTax());
		assertEquals(0.85, item1.getTaxPrice());
		assertEquals(0, item1.getTax());
		assertEquals(10.50, item1.getTaxPrice());
		assertEquals(50, item1.getTax());
		assertEquals(54.65, item1.getTaxPrice());
		assertEquals(7.15, item1.getTax());
		assertEquals(20.89, item1.getTaxPrice());
		assertEquals(2.10, item1.getTax());
		
	}

}
