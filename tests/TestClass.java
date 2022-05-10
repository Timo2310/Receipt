package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import shopping.Item;
import shopping.Receipt;


public class TestClass {
	
	Receipt receipt = new Receipt();
	
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
		assertEquals(1.90, item6.getTax(), 0.009);
	}
	
	@Test
	@DisplayName("Total Price3")
	public void calcTotal3() {
		receipt.add("1 imported bottle of perfume at 27.99", false);
		receipt.add("1 bottle of perfume at 18.99", false);
		receipt.add("1 packet of headache pills at 9.75", true);
		receipt.add("1 box of imported chocolates at 11.25", true);
		assertEquals(6.70, receipt.getSalesTaxTotal(), 0.009);
		assertEquals(74.68, receipt.getTotal(), 0.009);
		assertEquals(true, receipt.printReceipt());
	}
	
	@Test
	@DisplayName("Total Price2")
	public void calcTotal2() {
		receipt.add("1 imported box of chocolates at 10.00", true);
		receipt.add("1 imported bottle of perfume at 47.50", false);
		assertEquals(7.65, receipt.getSalesTaxTotal(), 0.009);
		assertEquals(65.15, receipt.getTotal(), 0.009);
		assertEquals(true, receipt.printReceipt());
	}
	
	@Test
	@DisplayName("Total Price1")
	public void calcTotal1() {
		receipt.add("1 book at 12.49", true);
		receipt.add("1 music CD at 14.99", false);
		receipt.add("1 chocolate bar at 0.85", true);
		assertEquals(1.50, receipt.getSalesTaxTotal(), 0.009);
		assertEquals(29.83, receipt.getTotal(), 0.009);
		assertEquals(true, receipt.printReceipt());
	}

}

