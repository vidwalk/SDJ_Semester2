package model;

public class CalculatedTax {

	public void update(TaxCalculation taxCalculator) {
		System.out.println("the tax is: " + taxCalculator.getTax() * taxCalculator.getIncome()/100);
	}

}
