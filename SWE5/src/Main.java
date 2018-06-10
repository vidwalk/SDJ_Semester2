import Calculator.Calculator;
import controller.CalcController;
import view.CalcConsole;
import view.CalcView;

public class Main {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		CalcView view = new CalcConsole();
		CalcController controller = new CalcController(calculator, view);

		view.startView(controller);
	}

}
