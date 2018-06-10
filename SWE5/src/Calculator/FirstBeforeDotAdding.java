package Calculator;

public class FirstBeforeDotAdding extends CalculatorState {
	
	public void operation(Calculator calculator)
	{
		calculator.setState(new OperationReady());
	}
	
	public void pressDot(Calculator calculator)
	{
		calculator.setState(new FirstAfterDotAdding());
	}
}
