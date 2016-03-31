package labtest01;

import java.util.Observable;
import java.util.Observer;

public class DisposeObserver implements Observer
{
	Inventory aInventory;
	int aTotalValue;
	
	public DisposeObserver(Inventory pInventory)
	{
		aInventory = pInventory;
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		this.aTotalValue = aInventory.totalValue();
		boolean added = aInventory.addedOrRemoved();
		if (added == false){
			System.out.println(this.aTotalValue +  " is now total quantity of inventory after disposing");
		}
		
	}
	

}
