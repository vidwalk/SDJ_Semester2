package view;

import java.util.Scanner;

import model.CalculatedTax;
import model.TaxCalculation;

public class View {
public static void main(String[] args)
{
	Scanner scan = new Scanner(System.in);
	CalculatedTax tax = new CalculatedTax();
	TaxCalculation taxCalculation = new TaxCalculation(tax);
	System.out.println("What is the income? ");
	taxCalculation.addIncome(scan.nextInt());
	System.out.println("What is the tax '%' ? ");
	taxCalculation.setTaxPercent(scan.nextInt());
	scan.close();
}
}
