package view;

import java.util.Observer;

import controller.CalcController;


public interface CalcView {
	String get(String string);
	void show(String text);
	void startView(CalcController controller);
}
