package shopping;

public class Item {
	
	private String name = "";
	private boolean type = false;
	private boolean imported = false;
	private double baseprice = 0.0;
	private double taxprice = 0.0;
	
	
	public Item (String productinfo, boolean type) {
		processPrInfo(productinfo);
		this.type = type;
	}
	
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
		return taxprice-baseprice;
	}
	
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
			name.concat(array[k]).concat(" ");
		}
		name = name.strip();
		calcTax();
		return;
	}
	
	public void calcTax() {
		
	}
	
	
	

}
