package domain.view;
import java.util.Observer;

import domain.controller.TemperatureController;
public interface TemperatureView extends Observer
{
 public void startView(TemperatureController controller);
 void show(String text);
}
