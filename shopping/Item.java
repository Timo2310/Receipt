package shopping;

public class Item {
	
	private String name;
	private boolean type;
	private boolean imported;
	private double baseprice;
	private double taxprice;
	
	
	public Item (String productinfo, boolean type) {
		processPrInfo();
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
	
	public void processPrInfo() {
		
	}
	
	public double getTaxPrice() {
		return taxprice;
	}
	
	public double getTax() {
		return taxprice-baseprice;
	}
	

}

