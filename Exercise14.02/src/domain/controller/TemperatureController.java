package domain.controller;
import domain.mediator.TemperatureModel;
import domain.model.Temperature;
import domain.view.TemperatureView;
public class TemperatureController
{
 private TemperatureModel model;
 private TemperatureView view;

 public TemperatureController(TemperatureModel model,
 TemperatureView view)
 {
 this.model = model;
 this.view = view;
 }
 public void execute(String what)
 {
 if (what.equalsIgnoreCase("update"))
 {
 Temperature t = model.getLastInsertedTemperature();
 view.show(t.toString());
 }
 }
}