package labtest01;

interface ItemInterface
{
	public String getName();
	public int getId();
}

class BaseItem implements ItemInterface
{
	
	@Override
	public String getName()
	{
		return "Item";
	}
	
	@Override
	public int getId()
	{
		return 0;
	}
}

public class ItemDecorator implements ItemInterface
{
	protected final ItemInterface aItem;
	
	public ItemDecorator(ItemInterface pItem)
	{
		aItem = pItem;
	}
	
	@Override
	public String getName()
	{
		return "-ITEM-" + aItem.getName();
	}
	
	@Override
	public int getId()
	{
		return 0 + aItem.getId();
	}

}

class CoffeeItem extends ItemDecorator
{
	static ItemInterface aItem;
	
	public CoffeeItem()
	{
		super(aItem);
	}
	
	public String getName()
	{
		return "Coffee";
	}
	
	public int getID()
	{
		return 123;
	}
	
}

class DonutItem extends ItemDecorator
{
	static ItemInterface aItem;
	
	public DonutItem()
	{
		super(aItem);
	}
	
	public String getName()
	{
		return "Donut";
	}
	public int getID()
	{
		return 0;
	}
}


