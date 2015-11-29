package postObject;

import java.util.ArrayList;

public class ItemList {

	private ArrayList<Item> items;
	
	ItemList(){
		items = new ArrayList<Item>();
	}
	
	
	public void addItem(Item i){
		items.add(i);
	}
	
	public void removeItem(int id, int quantity){
		for(int i = 0; i < items.size(); i++){
			
			Item temp = items.get(i);
			
			if(temp.getSpec().getId() == id){
				if(temp.getQuantity() > quantity){
					items.get(i).setQuantity(temp.getQuantity()-quantity);
				} else if(temp.getQuantity() == quantity){
					items.remove(i);
				} else {
					System.out.println("Discarding quantity cannot be greater than added quantity.");
				}
			}
		}
	}
	
	public int size(){
		return items.size();
	}
	
	public Item getItem(int i){
		return items.get(i);
	}
}
