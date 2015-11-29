package postObject;

public class BalanceManager {
	
	private static BalanceManager balanceManager = null;
	private String sReport = "";
	private double amount = 0;
	
	private BalanceManager(){
		
	}
	
	public static BalanceManager getBalanceManager(){
		if(balanceManager == null){
			balanceManager = new BalanceManager();
		}
		
		return balanceManager;
	}
	
	public void report(Sale sale){
		ItemList itemlist = sale.getItemList();																	// 2.1 itemlist=getItemList();
		for(int i = 0; i < itemlist.size(); i++){
			Item item = itemlist.getItem(i);																	// 2.2 item=getItem(i);
			ProductDescription spec = ProductCatalog.getProductCatalog().getItemSpec(item.getSpec().getId());	// 2.3 spec=getItemSpec(itemId);
			int stock = spec.getStock();																		// 2.4 stock=getStock();
			stock = stock-itemlist.getItem(i).getQuantity();
			ProductCatalog.getProductCatalog().getItemSpec(item.getSpec().getId()).setStock(stock);
		}
		
		amount += sale.getCharge();
		
		System.out.println(sReport);
	
	}
	
	public String showBalance(){
		
		sReport = "";
		
		for(int i = 0; i < ProductCatalog.getProductCatalog().size(); i++){
			sReport += "[ID:"+ProductCatalog.getProductCatalog().getItemSpec(i).getId()+"]"+
					"["+ProductCatalog.getProductCatalog().getItemSpec(i).getProductName()+"]"+
					"[Stock:"+ProductCatalog.getProductCatalog().getItemSpec(i).getStock()+"] \n";
		}
		
			sReport += "Total > "+amount+"\n";
		return sReport;
	}

}
