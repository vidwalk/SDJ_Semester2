package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoundedArrayQueueTest {
	private StringQueueADT queue;
	@Before
	public void setUp() throws Exception
	{
	queue = new BoundedArrayQueue(10);
	}

	@Test
	public void testSizeAndQueing() {
		queue.enqueue("A");
		queue.enqueue("B");
		assertEquals(10,queue.size());
		assertEquals("A",queue.dequeue());
		assertEquals("B",queue.dequeue());
		queue.enqueue("C");
		assertEquals("{C }", queue.toString());
	}
	@Test(expected =
			IllegalStateException.class)
	public void testException()
	{
		queue.dequeue();
	}
	@After
	public void tearDown() throws Exception
	{
	// nothing
	}
}
