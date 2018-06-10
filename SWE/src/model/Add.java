package model;

public class Add extends Math {

	public Add(Calculator calculator) {
		super(calculator);
		calculator.addTypeOfCalculation(this);
	}

	@Override
	public void update(int value1, int value2) {
		System.out.print("the add result is: ");
		System.out.println( value1 + value2);
	}

}
