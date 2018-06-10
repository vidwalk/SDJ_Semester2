package Calculator;

public class Add implements Operation {

	@Override
	public double operate(double number1, double number2) {
		return number1 + number2;
	}

}
