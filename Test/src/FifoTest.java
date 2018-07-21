import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FifoTest {
	private Fifo sut = null;
	private final int FIFO_SIZE = 3;

	private Object deQueueElement() {
		try {
			return sut.dequeue();
		} catch (FifoEmptyException e) {
			e.printStackTrace();
		}

		return null;
	}

	private void enqueueElement(Object o) {
		try {
			sut.enqueue(o);
		} catch (FifoFullException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {
		sut = new Fifo(FIFO_SIZE);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Zero
	@Test
	public void testCanBeInstantiated() {
		assertNotNull(sut);
	}

	@Test
	public void testEmptyWhenInstantiated() {
		assertTrue(sut.isEmpty());
	}

	@Test
	public void testNotFullWhenInstantiated() {
		assertFalse(sut.isFull());
	}

	// One
	@Test
	public void testElementCanBeEnqueued() {
		enqueueElement(1);
	}

	@Test
	public void testElementCanBeDequeued() {
		enqueueElement(1);
		assertEquals(1, deQueueElement());
	}

	@Test
	public void testNotEmptyWhenElementIsQueued() {
		enqueueElement(1);
		assertFalse(sut.isEmpty());
	}

	@Test
	public void testNotFullWhenElementIsQueued() {
		enqueueElement(1);
		assertFalse(sut.isFull());
	}

	// Many/More
	@Test
	public void testTwoElementsCanBeEnqueued() {
		enqueueElement(1);
		enqueueElement(2);
	}

	@Test
	public void testTwoElementsCanBeDequeued() {
		enqueueElement(1);
		enqueueElement(2);
		assertEquals(1, deQueueElement());
		assertEquals(2, deQueueElement());
	}

	@Test
	public void testCanWrapWhenQueing() {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}

		deQueueElement();
		enqueueElement(100);
	}

	@Test
	public void testCanDequeueAfterWrap() {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}

		for (int i = 0; i < FIFO_SIZE; i++) {
			assertEquals(i,deQueueElement());
		}

		enqueueElement(100);
		assertEquals(100,deQueueElement());
	}

	// Boundary Behaviour
	@Test
	public void testFifoCanBeFilled() {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}
	}

	@Test
	public void testIsFullWhenFilledUp() {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}

		assertTrue(sut.isFull());
	}

	@Test
	public void testIsNotFullWhenFilledUpAndOneElementIsDequeued() {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}

		deQueueElement();
		assertFalse(sut.isFull());
	}

	@Test
	public void testIsEmptyWhenOneElementIsQueuedAndDequeued() {
		enqueueElement(1);
		deQueueElement();
		assertTrue(sut.isEmpty());
	}

	// Exceptional behaviour
	@Test (expected = FifoEmptyException.class)
	public void testFifoEmptyExceptionThrownWhenDequeuedFromEmptyFifo() throws FifoEmptyException {
		sut.dequeue();
	}

	@Test (expected = FifoFullException.class)
	public void testFifoFullExceptionThrownWhenEnqueueToFullFifo() throws FifoFullException {
		for (int i = 0; i < FIFO_SIZE; i++) {
			enqueueElement(i);
		}

		sut.enqueue(100);
	}
	//defines the needed interfaces for our modules
	// simple scenarios, simple solutions
}
