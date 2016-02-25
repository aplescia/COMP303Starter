package labtest01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestItemDecorator
{
	@Test
	public void testGetName()
	{
		CoffeeItem lCoffee = new CoffeeItem();
		ItemDecorator lDecorator = new ItemDecorator(lCoffee);
		assertEquals(lCoffee.getName(), "Coffee");
		assertEquals(lDecorator.getName(), "-ITEM-" + lCoffee.getName());
	}

}
