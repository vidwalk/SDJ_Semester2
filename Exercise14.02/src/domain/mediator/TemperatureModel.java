package domain.mediator;
import domain.model.Temperature;
public interface TemperatureModel
{
 public void addTemperature(int temperature);
 public Temperature getLastInsertedTemperature();
}
