package domain.mediator;
import java.util.Observable;

import domain.model.Temperature;
import domain.model.TemperatureList;
public class TemperatureModelManager extends Observable implements TemperatureModel
{
 private TemperatureList temperatureList;
 public TemperatureModelManager()
 {
 temperatureList = new TemperatureList();
 }

 @Override
 public void addTemperature(int value)
 {
 Temperature temperature = new Temperature(value);
 this.temperatureList.addTemperature(temperature);
setChanged();
notifyObservers();
 }

 @Override
 public Temperature getLastInsertedTemperature()
 {
 return temperatureList.getTemperature(0);
 }

 public TemperatureList getAllTemperatures()
 {
 return temperatureList;
 }
}