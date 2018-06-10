package domain.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import domain.controller.TemperatureController;

public class GuiButtonHandler implements ActionListener {
	private TemperatureController controller;

	public GuiButtonHandler(TemperatureController controller) {
		this.controller = controller;
	}

	public void actionPerformed(ActionEvent event) {
		controller.execute("Update");
	}
}