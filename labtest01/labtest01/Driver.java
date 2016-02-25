package labtest01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Utility class with a driver program and some 
 * sample items and inventories.
 */
public final class Driver
{
	private static final Item ITEM_CEREAL = new Item("Cereal", 1, 200);
	private static final Item ITEM_JAM = new Item("Jam", 2, 400);
	private static final Item ITEM_BUTTER = new Item("Butter", 3, 250);
	
	private static final Item[] ITEMS = { ITEM_CEREAL, ITEM_JAM, ITEM_BUTTER };
	
	private Driver() {}
	
	/**
	 * @param pArgs Not used
	 */
	public static void main(String[] pArgs)
	{
		
		List<Item> sortList = new ArrayList<>();
		
		for( Item item : ITEMS )
		{
			System.out.println(item.getName());
			sortList.add(item);
		}
		
		Collections.sort(sortList, new ItemComparator());
		System.out.println("--------");
		
		for (Item item : sortList)
		{
			System.out.println(item.getName());
		}
		
		System.out.println("-------");
				
		
		Inventory lInventory = new Inventory("Test Inventory");
		for (Item item : ITEMS)
		{
			lInventory.stock(item, 1);
		}
		//lInventory.dispose(null, 0);
		System.out.println(lInventory.totalValue());		
	}
}
