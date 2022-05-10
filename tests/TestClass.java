package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import shopping.Item;


public class TestClass {
	
	Item item1 = new Item("book at 12.49", true);
	Item item2 = new Item("music CD at 14.99", false);
	Item item3 = new Item("chocolate bar at 0.85", true);
	Item item4 = new Item("imported box of chocolates at 10.00", true);
	Item item5 = new Item("imported bottle of perfume at 47.50", false);
	Item item6 = new Item("bottle of perfume at 18.99", false);
	
	@Test
	@DisplayName("Getter/Setter_Test")
	public void testGetSet() {
		assertEquals("book", item1.getName());
		assertEquals(true, item1.getType());
		assertEquals(12.49, item1.getPrice(), 0.009);
		assertEquals(false, item1.isImported());
	}
	
	@Test
	@DisplayName("Tax_calculation")
	public void testTaxCalc() {
		assertEquals(12.49, item1.getTaxPrice(), 0.009);
		assertEquals(0, item1.getTax(), 0.009);
		assertEquals(16.49, item2.getTaxPrice(), 0.009);
		assertEquals(1.50, item2.getTax(), 0.009);
		assertEquals(0.85, item3.getTaxPrice(), 0.009);
		assertEquals(0, item3.getTax(), 0.009);
		assertEquals(10.50, item4.getTaxPrice(), 0.009);
		assertEquals(0.50, item4.getTax(), 0.009);
		assertEquals(54.65, item5.getTaxPrice(), 0.009);
		assertEquals(7.15, item5.getTax(), 0.009);
		assertEquals(20.89, item6.getTaxPrice(), 0.009);
		assertEquals(2.10, item6.getTax(), 0.009);
		
	}
	
	
	@Test
	@DisplayName("Total Price")
	public void calcTotal() {
		receipt.add("1 book at 12.49", true);
		receipt.add("1 music CD at 14.99", false);
		receipt.add("1 chocolate bar at 0.85", true);
		assertEquals("1.50", receipt.getSalesTaxTotal());
		assertEquals("29.83", receipt.getTotal());
		assertEquals(true, receipt.printReceipt());
	}

}
