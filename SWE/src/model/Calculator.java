package model;

import java.util.ArrayList;

public class Calculator {
	private ArrayList<Math> maths;
	private int result;
	private Area area;
	public Calculator() {
		maths = new ArrayList<Math>();
		area = new Area();
	}

	public int getResult() {
		return result;
	}

	public void calculateAll(int value1, int value2) {
		for (int i = 0; i < maths.size(); i++)
			maths.get(i).update(value1, value2);
	}

	public void addTypeOfCalculation(Math math) {
		maths.add(math);
	}

	public void drawArea(int value1, int value2)
	{
		area.draw(value1, value2);
	}
}
