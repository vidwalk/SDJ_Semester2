package view;

import controller.CalcController;

public class TimerReset implements Runnable {
	private CalcController controller;
	long start;
	long end;
	
	public TimerReset(CalcController controller)
	{
		this.controller = controller;
		start = System.currentTimeMillis();
		end = start + 300 * 1000; // 60 seconds * 1000 ms/sec
	}

	@Override
	public void run() {
		while (System.currentTimeMillis() <= end) {
			if (System.currentTimeMillis() == end) {
				controller.execute(0);
				System.out.println("calculator closed");
			}
	}
	}

	public void reset()
	{
		start = System.currentTimeMillis();
		end = start + 300 * 1000; // 60 seconds * 1000 ms/sec
	}
}
