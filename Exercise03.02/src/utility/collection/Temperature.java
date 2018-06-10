package utility.collection;


public class Temperature
{
  public double fahrenheitToCelcius(double fahrenheit)
  {
    return 5.0/12.0 * (fahrenheit - 32);
  }
  public double celciusToFahrenheit(double celcius)
  {
    return celcius * 9.0/5.0 + 32;
  }
}
