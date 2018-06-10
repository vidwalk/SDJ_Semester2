package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utility.collection.ArrayStack;
import utility.collection.StackADT;

public class ArrayStackTest {
	private StackADT<String> stack;
	@Before
	public void setUp() throws Exception
	{
	stack = new ArrayStack<>();
	}
	@Test
	public void testPushAndPopAFew()
	{
	stack.push("$A$");
	assertEquals("$A$", stack.pop());
	stack.push("$B$");
	stack.push("$D$");
	assertEquals("$D$", stack.pop());
	assertEquals("$B$", stack.pop());
	try
	{
	stack.push(null);
	assertEquals(null, stack.pop());
	stack.push(null);
	stack.push("$A$");
	assertEquals("$A$", stack.pop());
	assertEquals(null, stack.pop());
	}
	catch (IllegalArgumentException e)
	{
	// OK
	}
	}
	@Test(expected =
			IllegalStateException.class)
			public void testPopExcepion()
			{
			stack.pop();
			}
	@After
	public void tearDown() throws Exception
	{
	// nothing
	}

}
