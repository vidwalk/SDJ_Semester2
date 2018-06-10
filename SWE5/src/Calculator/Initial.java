package Calculator;

public class Initial extends CalculatorState {

	public void addDigit(Calculator calculator)
	{
		calculator.setState(new FirstBeforeDotAdding());
	}
	
	public void pressDot(Calculator calculator)
	{
		calculator.setState(new FirstAfterDotAdding());
	}
}
