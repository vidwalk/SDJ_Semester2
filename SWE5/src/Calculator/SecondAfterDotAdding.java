package Calculator;

public class SecondAfterDotAdding extends CalculatorState{
	public void equal (Calculator calculator)
	{
		calculator.setState(new DisplayResult());
	}
	public void operation (Calculator calculator)
	{
		calculator.setState(new OperationReady());
	}
}
