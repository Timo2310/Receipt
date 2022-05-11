package shopping;

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
		taxprice = baseprice + tax;
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
		
		for(int k = 0; k < array.length-1; k++) {
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
		
		double t = (saletax*0.1) + (importtax*0.05);
		
		t = t*baseprice*100;
		
		while(t%5 != 0) {
			t = t+0.05;
			t = Math.ceil(t);
		}
		tax = t/100;
		return;
	}	
	
}
