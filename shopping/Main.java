package shopping;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String order = "";
		boolean type = false;
		Receipt receipt = new Receipt();
		boolean stop = false;
		
		do {
			System.out.println("This is your shopping cart!");
			order = "";
			type = false;
			
			do {
				System.out.println("Please enter your order: ");
				System.out.println("(Enter 'stop' to get your receipt.)");
				order = scan.nextLine();
				if(order.equals("stop")) {
					stop = true;
					break;
				}
				
				try {
					
					String[] array = order.split(" ");
					Integer.parseInt(array[0]);
					Double.parseDouble(array[array.length-1]);
					System.out.println("");
					break;
					
				} catch(Exception e) {
					System.out.println("This is not the correct format.");
					System.out.println("The order must follow this format:");
					System.out.println("poductcount_productname_at_priceWithoutCurrencySign");
					System.out.println("Please try again!");
					System.out.println("");
					order = "";
				}
			} while(!stop);
			
			while(!stop) {
				System.out.println("Is this a food, book or medical supply?");
				System.out.println("(Please enter 'y' for yes or 'n' for no and submit with 'enter'.)");
				String typ = scan.nextLine();
				if(typ.equals("n")) {
					type = false;
					System.out.println("");
					break;
				}
				if(typ.equals("y")) {
					type = true;
					System.out.println("");
					break;
				}
				System.out.println("Please only enter 'y' or 'n' and submit with 'enter'.");
				System.out.println("");
			};
			
			if(!stop){
				receipt.add(order, type);
				System.out.println("This is your current shopping basket:");
				receipt.printBasket();	
			}
			
		} while (!stop);
		
		System.out.println("Thank you for your purchase!");
		System.out.println("This is your receipt:");
		receipt.printReceipt();
		System.out.println("Have a nice day!");
		scan.close();
		System.exit(0);	
	}

}
