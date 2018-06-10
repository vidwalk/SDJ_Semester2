package Calculator;

public class SecondBeforeDotAdding extends CalculatorState {
	public void equal (Calculator calculator)
	{
		calculator.setState(new DisplayResult());
	}
	public void operation (Calculator calculator)
	{
		calculator.setState(new OperationReady());
	}
	public void pressDot (Calculator calculator)
	{
		calculator.setState(new SecondAfterDotAdding());
	}
}
