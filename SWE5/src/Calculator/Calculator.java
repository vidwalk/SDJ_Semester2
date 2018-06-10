package Calculator;

import view.TimerReset;

public class Calculator{
	private CalculatorState state;
	private Operation operation;
	private double number1;
	private double number2;
	private int overflow;
	private double dotCounter1;
	private double dotCounter2;
		
	public Calculator() {
		state = new Initial();
		number1 = 0;
		number2 = 0;
		overflow = 0;
		dotCounter1 = 0.1;
		dotCounter2 = 0.1;
	}

	public void setState(CalculatorState state) {
		this.state = state;
	}

	public void addDigit(int digit) {
		state.addDigit(this);
		if(overflow < 9)
		{
		if (status().substring(11, 22).equals("FirstBefore")) {
			number1 = number1 * 10 + digit;
		}
		if (status().substring(11, 23).equals("SecondBefore")) {
			number2 = number2 * 10 + digit;
		}
		if (status().substring(11, 21).equals("FirstAfter")) {
			dotCounter2 = 0.1;
			number1 = (double) (number1 + digit * dotCounter1);
			dotCounter1 = dotCounter1 / 10;
		}
		if (status().substring(11, 22).equals("SecondAfter")) {
			dotCounter1 = 0.1;
			number2 = (double) (number2 + digit * dotCounter2);
			dotCounter2 = dotCounter2 / 10;
		}
		overflow++;
		}
	}

	public String status() {
		return state.getClass().getName();
	}

	public void showResult(Operation operation) {
		if(dotCounter1 == 0.1 && dotCounter2 == 0.1)
		{
		int result = (int) operation.operate(number1, number2);
		number1 = result;
		System.out.println(result);
		}
		else
		{
		number1 = operation.operate(number1, number2);
		System.out.println(number1);
		}
		number2 = 0;
	}

	public void pressDot() {
		if (!status().substring(11, 22).equals("SecondAfter"))
		state.pressDot(this);
	}

	public void operation(Operation operation) {
		this.operation = operation;
		if(status().substring(11, 22).equals("SecondAfter") || status().substring(11, 23).equals("SecondBefore"))
		{
			showResult(this.operation);
			
		}
		state.operation(this);
		overflow = 0;
	}

	public void equal() {
		state.equal(this);
		showResult(this.operation);
	}

	public void clear() {
		number1 = 0;
		number2 = 0;
		state = new Initial();
		overflow = 0;
	}

	public void close()
	{
		System.out.println("timeout");
		System.exit(0);
	}
}
