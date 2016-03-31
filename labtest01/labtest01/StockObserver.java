package labtest01;
import java.util.*;
public class StockObserver implements Observer
{
	Inventory aInventory;
	int aTotalValue;
	
	public StockObserver(Inventory pInventory)
	{
		this.aInventory = pInventory;
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
		// TODO Auto-generated method stub
		
		aTotalValue = aInventory.totalValue();
		boolean added = aInventory.addedOrRemoved();
		if (added == true){
			System.out.println(aTotalValue + " is total quantity after item added to inventory!");
		}

	}

}
