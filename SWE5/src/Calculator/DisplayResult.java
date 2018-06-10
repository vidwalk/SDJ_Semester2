package Calculator;

public class DisplayResult extends CalculatorState {
	public void operation(Calculator calculator)
	{
		calculator.setState(new OperationReady());
	}
}
