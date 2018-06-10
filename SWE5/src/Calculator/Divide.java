package Calculator;

public class Divide implements Operation {

	@Override
	public double operate(double number1, double number2) {
		if(number2 == 0 && number1 != 0)
		{
			try
			{
			return (Double) null;
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
		}
		return number1 / number2;
	}

}
