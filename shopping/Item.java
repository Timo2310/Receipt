package shopping;

import java.text.DecimalFormat;


public class Item {
	
	private String name = "";
	private boolean type = false;
	private boolean imported = false;
	private double baseprice = 0.0;
	private double taxprice = 0.0;
	private double tax = 0.0;
	
	//Constructor
	public Item (String productinfo, boolean type) {
		this.type = type;
		processPrInfo(productinfo);
		taxprice = round(baseprice + tax);
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public boolean getType() {
		return type;
	}
	
	public double getPrice() {
		return baseprice;
	}
	
	public boolean isImported() {
		return imported;
	}
	
	public double getTaxPrice() {
		return taxprice;
	}
	
	public double getTax() {
		return tax;
	}
	
	//processes given productinfo
	public void processPrInfo(String info) {
		if(info.contains("imported")) {
			imported = true;
			int i = info.indexOf("imported");
			info = info.substring(0, i).concat(info.substring(i+8));
		}
		
		String[] array = info.split(" ");
		
		baseprice = Double.parseDouble(array[(array.length-1)]);
		
		for(int k = 0; k < array.length; k++) {
			if(array[k].equals("at")) {
				break;
			}
			name = name.concat(array[k]).concat(" ");
		}
		name = name.strip();
		calcTax();
		return;
	}
	
	//calculates tax and rounds it up (only the tax!)
	public void calcTax() {
		
		double importtax = 0.0;
		double saletax = 0.0;
		if(imported) {
			importtax = 1.0;
		}
		if(!type) {
			saletax = 1.0;
		}

		tax = roundUp((importtax * (baseprice/20)) + (saletax * baseprice/10));
		return;
	}
	
	//rounds up a number at 2 digits after the decimal
	public double roundUp(double number) {
		if (number <0.01) {
			return 0.0;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		String numbers = df.format(number).replace(",",".");
		int index = numbers.indexOf(".");
		String round = "0";
		int at = Integer.parseInt(Character.toString(numbers.charAt(index+2)));
		if(at > 0 && at < 5) {
			round = "5";
		}
		numbers = numbers.substring(0, index+2).concat(round);
		return (Double.parseDouble(numbers));
	}
	
	//limits a number to two places after a decimal
	public double round(double number) {
		DecimalFormat df = new DecimalFormat("0.00");
		String numbers = df.format(number).replace(",",".");
		return Double.parseDouble(numbers);
	}

}
