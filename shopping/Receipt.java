package shopping;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Receipt {
	
	private ArrayList<Item> basket = new ArrayList<Item>();
	
	public Receipt() {
		
	}
	
	public void add(String order, boolean type) {
		int count = 0;
		try {
			count = Integer.parseInt(Character.toString(order.charAt(0)));
			String product = order.substring(2);
			for(int i = 0; i < count; i++) {
				basket.add(new Item(product, type));
			}
		} catch (Exception e) {
			count = 1;
			String product = order.substring(0);
			for(int i = 0; i < count; i++) {
				basket.add(new Item(product, type));
			}
		}
		return;
		
	}
	
	public double getTotal() {
		double total = 0.0;
		for(int i = 0; i < basket.size(); i++) {
			total += basket.get(i).getTaxPrice();
		}
		return total;
	}
	
	public double getSalesTaxTotal() {
		double total = 0.0;
		for(int i = 0; i < basket.size(); i++) {
			total += basket.get(i).getTax();
		}
		return total;
	}
	
	public boolean printBasket() {
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			for(int u = 0; u < basket.size(); u++) {
				System.out.print("1 ");
				if(basket.get(u).isImported()) {
					System.out.print("imported ");
				}
				System.out.println(basket.get(u).getName() + ": " + df.format(basket.get(u).getTaxPrice()).replace(",","."));
			}
			System.out.println("");
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean printReceipt() {
		DecimalFormat df = new DecimalFormat("0.00");
		try {
			for(int u = 0; u < basket.size(); u++) {
				System.out.print("1 ");
				if(basket.get(u).isImported()) {
					System.out.print("imported ");
				}
				System.out.println(basket.get(u).getName() + ": " + df.format(basket.get(u).getTaxPrice()).replace(",","."));
			}
			System.out.println("Sales Taxes: " + df.format(getSalesTaxTotal()).replace(",","."));
			System.out.println("Total: " + df.format(getTotal()).replace(",","."));
			System.out.println("");
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}



