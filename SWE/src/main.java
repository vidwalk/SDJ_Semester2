import model.Add;
import model.Calculator;
import model.Math;
import model.Multiply;
import model.Substract;

public class main {

	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();
		Math math = new Add(calculator);
		Math math2 = new Substract(calculator);
		Math math3 = new Multiply(calculator);
		calculator.calculateAll(20, 30); // they don't implements observer or extend observable
		// it's observer-like
		calculator.drawArea(5, 4);
	}
}
