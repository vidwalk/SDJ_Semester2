package model;

import java.util.ArrayList;

public class TaxCalculation {
private int taxPercent;
private CalculatedTax calculatedTax;
private int income;

public TaxCalculation(CalculatedTax calculatedTax)
{
	this.calculatedTax = calculatedTax;
}
public int getTax()
{
	return taxPercent;
}

public void addIncome(int income)
{
	this.income = this.income + income;
}

public void setTaxPercent(int taxPercent)
{
	this.taxPercent = taxPercent;
	this.calculate();
}

public void calculate()
{
	calculatedTax.update(this);
}

public int getIncome() {
	return income;
}
}
