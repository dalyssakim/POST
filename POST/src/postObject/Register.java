package postObject;

public class Register {
	
	private Sale sale = null;
	private Sale tempSale = null;
	double change = 0;
	
	
	public void addItem(int id, int qty){
		
		if(sale == null){
			sale = new Sale(); 															// 1 create
		}
		

		ProductDescription spec = ProductCatalog.getProductCatalog().getItemSpec(id); 	// 2 spec=getItemSpec
		sale.addItem(spec, qty); 														// 3 addItem(spec, quantity)
		
		
	}
	
	public void discardItem(int id, int quantity){
		sale.discardItem(id, quantity);													// 1 discardItem(id, quntity)
	}
	
	public void finishSale(double amount){
		
		
		change = sale.getChange(amount);												// 1 change=getChange(amount)	
		if(change < 0){
			//exception
		}
		
		BalanceManager.getBalanceManager().report(sale);								// 2 report(sale)

		/*
		 * These two statements below has added for displaying purpose.
		 * When using GUI, it should go like this.
		 * 
		 * notify(Views) - notify to the views
		 * sale = null - nullify sale to terminate sale
		 * 
		 * Since I am using console for displaying 
		 * this tempSale is needed for it has to display sale list even though it is nullified.
		 * 
		 */
		
		tempSale = sale;
		sale = null;
		
	}
	
	
	/*
	 * Code for console display
	 */
	
	public void print(int status){
		
		ItemList itemlist;
		Sale printsale;
		
		if(sale == null){
			printsale = tempSale;
		} else {
			printsale = sale;
		}
		
		itemlist = printsale.getItemList();		
		
		if(status != 2){
		for(int i = 0; i < itemlist.size(); i++){
			String productName = itemlist.getItem(i).getSpec().getProductName();
			double cost = itemlist.getItem(i).getSpec().getCost()*itemlist.getItem(i).getQuantity();
			int quantity = itemlist.getItem(i).getQuantity();
			System.out.println("["+productName+"]"+"["+quantity+"]"+"["+cost+"]");
		}
		System.out.println("Total > "+printsale.getCharge());

		if(status == 1){
			System.out.println("Here is your change > "+change);
		}
		}	
		}
}
