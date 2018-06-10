package Calculator;

public class FirstAfterDotAdding extends CalculatorState {
	
	public void operation(Calculator calculator)
	{
		calculator.setState(new OperationReady());
	}
}
