package Calculator;

public abstract class CalculatorState {

	public void addDigit(Calculator calculator){};
	
	public void pressDot(Calculator calculator){};
	
	public void operation(Calculator calculator){};
	
	public void equal(Calculator calculator){};
}
