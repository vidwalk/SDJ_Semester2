package Calculator;

public class OperationReady extends CalculatorState {
	public void addDigit(Calculator calculator)
	{
		calculator.setState(new SecondBeforeDotAdding());
	}
	public void pressDot (Calculator calculator)
	{
		calculator.setState(new SecondAfterDotAdding());
	}
}
