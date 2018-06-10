package utils.collection;

import thread.producerconsumer.queues.ArrayQueue;
import thread.producerconsumer.queues.QueueADT;

public class WashingHall {
	private QueueADT<Hall> availableHalls;
	private int occupiedHalls;
	private boolean changed;

	public WashingHall(int numberOfWashingHalls) {
		availableHalls = new ArrayQueue<>(numberOfWashingHalls);
		for (int i = 0; i < numberOfWashingHalls; i++)
			availableHalls.enqueue(new Hall(i));
	}

	/*
	 * Customer enters for washing the car. A customer waits if all washing places
	 * are occupied
	 */
	public synchronized Hall enterForWashing() {
		while (availableHalls.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		occupiedHalls++;
		Hall hall = availableHalls.dequeue();
		changed = true;
		notifyAll();
		return hall;
	}

	/*
	 * Car washing has finished and customer leaves the washing place so that the
	 * next waiting car can enter.
	 */
	public synchronized void leaveWashing(Hall hall) {
		while (availableHalls.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		availableHalls.enqueue(hall);
		occupiedHalls--;
		changed = true;
		notifyAll();

	}

	public synchronized int getFreePlaces() {
		while (changed == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		changed = false;
		notifyAll();
		return availableHalls.size() - occupiedHalls;
	}
}
