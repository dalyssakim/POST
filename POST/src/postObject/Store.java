package postObject;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {

	/*
	 * Date : 12/08/2014
	 * Author : Dajung Kim
	 * Purpose : Software Design Methodology - Prototype of POST
	 * 
	 * NOTE! 
	 * MAIN is not included in collaboration diagram.
	 * 
	 * TO SUPPORT MULTIPLE REGISTERS
	 * Because it is prototype of POST, it does not support multiple registers right now.
	 * To support multiple registers, just make multiple register objects,
	 * put the whole while(true){} statement into new method,
	 * and create threads for each register objects.
	 * This is described in Section 8. Domain Model as "Store" houses "Register".
	 * 
	 * Balance will be calculated based on all the sales in registers 
	 * since it is Singleton Object.
	 * 
	 */

//	public static void main(String args[]){
	public void haha(){
		ArrayList<ProductDescription> specs = new ArrayList<ProductDescription>();
		Register register = new Register();
		int status = 0;
		Scanner scan = new Scanner(System.in);

		/*
		 * Have to be File/Database but Here uses predefined Product Description 
		 */

		specs.add(new ProductDescription(0, "Welchs", 1.00, 100));
		specs.add(new ProductDescription(1, "Heineken", 2.00, 100));
		specs.add(new ProductDescription(2, "Budweiser", 3.00, 100));
		specs.add(new ProductDescription(3, "Blue Moon", 4.00, 100));
		specs.add(new ProductDescription(4, "Cass", 1.00, 100));
		
		/* Product Catalog - Singleton Object*/
		ProductCatalog.getProductCatalog().setProductDescription(specs);
		
		
		while(true){
			
		/*
		 * Menu
		 */
		System.out.println("#### Welcome To The Store ####");
		System.out.println("# /addItem id quantity");
		System.out.println("# /discardItem id quantity");
		System.out.println("# /finishSale amount");
		System.out.println("# /showBalance");
		System.out.println("# /quit");
		System.out.println("##############################");
		
		while(status == 0){
		String input = scan.nextLine();
		String command[] = input.split(" ");
		if(command[0].equals("/addItem")){							// Usecase 1. BuyItem
			int id = Integer.parseInt(command[1]);
			int quantity = Integer.parseInt(command[2]);
			
			register.addItem(id, quantity);
		}else if(command[0].equals("/discardItem")){				// Usecase 2. Discard Item
			int id = Integer.parseInt(command[1]);
			int quantity = Integer.parseInt(command[2]);
			register.discardItem(id, quantity);
		} else if(command[0].equals("/finishSale")){				// Usecase 1. BuyItem - FinishSale
			double amount = Double.parseDouble(command[1]);
			register.finishSale(amount);
			status = 1;
			System.out.println("#### See You Next Time! ####");
		} else if(command[0].equals("/showBalance")){				// Usecase 3. Show Balance
			System.out.println(BalanceManager.getBalanceManager().showBalance());
			status = 2;
		} else if(command[0].equals("/quit")){
			System.out.println("#### Store Closed For Today ####");
			status = 2;
			register.print(status);
			System.out.println("################################");
			System.exit(0);
		} else {
			System.out.println("Command Not Supported");
		}
		
			register.print(status);
		
		}
		
			status = 0;
		}
	}
}
