package labtest01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Represents the inventory of a 
 * physical grocery store.
 */
public class Inventory extends Observable
{
	private final String aName; // Unique
	private List<Observer> aObservers;
	private int aTotalItems;
	private final HashMap<Item, Integer> aInventory = new HashMap<>();
	private Item aLastItem;
	private boolean aAdded;
	
	/**
	 * Creates a new inventory with no items in it,
	 * and identified uniquely with pName.
	 * @param pName A unique identifier for this inventory.
	 */
	public Inventory(String pName)
	{
		super();
		aName = pName;
		aObservers = new ArrayList<>();
	}
	
	/**
	 * @return The unique name of this inventory.
	 */
	public String getName()
	{
		return aName;
	}
	
	public boolean addedOrRemoved()
	{
		return this.aAdded;
	}
	
//	@Override
//	public void addObserver(Observer pObserver)
//	{
//		if (!this.aObservers.contains(pObserver))
//			this.aObservers.add(pObserver);
//		super.addObserver(pObserver);
//	}
	
//	@Override
//	public void notifyObservers(Object arg)
//	{
//		if (arg == null){
//			for (Observer a : this.aObservers)
//			{
//				if (a.getClass() == DisposeObserver.class)
//					a.update(this, null);
//			}
//		}else{
//			for (Observer a : this.aObservers)
//			{
//				if (a.getClass() == StockObserver.class)
//					a.update(this, null);
//			}
//			
//		}
//	}
	
	/**
	 * Adds pQuantity number of items to the inventory.
	 * @param pItem The type of item to add.
	 * @param pQuantity The amount to add.
	 */
	public void stock(Item pItem, int pQuantity)
	{
		int amount = 0;
		if( aInventory.containsKey(pItem))
		{
			amount = aInventory.get(pItem);
		}
		amount += pQuantity;
		aTotalItems += pQuantity;
		aInventory.put(pItem, amount);
		this.aLastItem = pItem;
		this.aAdded = true;
		setChanged();
		notifyObservers();
		clearChanged();

	}
	
	public Item getLastItem()
	{
		return this.aLastItem;
	}
	
	/**
	 * Removes pQuantity of items from the inventory,
	 * for example by selling them or tossing them in
	 * the garbage.
	 * @param pItem The type of item to dispose of
	 * @param pQuantity The amount to dispose.
	 * @pre aInventory.containsKey(pItem) && pQuantity >= aInventory.get(pItem)
	 */
	public void dispose(Item pItem, int pQuantity)
	{
		assert pItem != null;
		int amount = aInventory.get(pItem);
		amount -= pQuantity;
		aInventory.put(pItem, amount);
		aTotalItems -= pQuantity;
		this.aAdded = false;
		setChanged();
		notifyObservers();
		clearChanged();
	}
	
	/**
	 * @param pItem The item to check for availability.
	 * @return How many of the items are available in the inventory.
	 */
	public int pAvailable(Item pItem)
	{
		if( aInventory.containsKey(pItem))
		{
			return aInventory.get(pItem);
		}
		else
		{
			return 0;
		}
	}
	
	public int totalValue()
	{
		return aTotalItems;
	}
}
