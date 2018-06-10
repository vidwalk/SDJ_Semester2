package model;
public class Multiply extends Math {

	public Multiply(Calculator calculator) {
		super(calculator);
		calculator.addTypeOfCalculation(this);
	}

	@Override
	public void update(int value1, int value2) {

		System.out.print("the multiply result is: ");
		System.out.println(value1*value2);
	}

}
