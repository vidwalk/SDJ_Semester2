package controller;

import java.util.Date;
import java.util.Observable;

import Calculator.Add;
import Calculator.Calculator;
import Calculator.Divide;
import Calculator.Multiply;
import Calculator.Subtract;
import view.CalcView;

public class CalcController {
	
	private Calculator model;
	private CalcView view;
	
	public CalcController(Calculator model, CalcView view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void execute(int choice)
	{
		switch(choice)
		{
		case 1:
			model.addDigit(Integer.parseInt(view.get("digit")));
			break;
			
		case 2:
			model.pressDot();
			break;
			
		case 3:
			model.operation(new Add());
			break;
			
		case 4:
			model.operation(new Subtract());
			break;
			
		case 5:
			model.operation(new Multiply());
			break;
			
		case 6:
			model.operation(new Divide());
			break;
			
		case 7:
			model.equal();
			break;
			
		case 8:
			model.clear();
			break;
			
		case 0: 
			model.close();
			break;
			
		default:
			view.show("Invalid input");
			break;
		}
	}
}
