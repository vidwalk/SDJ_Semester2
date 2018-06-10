package utility.collection;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperatureEventHandlers
{
   @FXML
   private TextField textInput;

   @FXML
   private Label labelTimer;

   @FXML
   private Label labelOutput;

   private Temperature model;

   @FXML
   private URL location;

   @FXML
   private ResourceBundle resources;

   public TemperatureEventHandlers(Temperature model)
   {
      this.model = model;
   }

   @FXML
   private void initialize()
   {
   }

   @FXML
   private void toCelcius()
   {
      String txt = "";
      double temp = 0;
      try
      {
         temp = Double.parseDouble(textInput.getText());
         double t = model.celciusToFahrenheit(temp);
         txt = "Output: " + temp + " Celcius = " + t + " Fahrenheit";
      }
      catch (Exception e)
      {
         txt = "Error: " + e.getMessage();
      }
      showOutput(txt);
   }

   @FXML
   private void toFahrenheit()
   {
      String txt = "";
      double temp = 0;
      try
      {
         temp = Double.parseDouble(textInput.getText());
         double t = model.fahrenheitToCelcius(temp);
         txt = "Output: " + temp + " Fahrenheit = " + t + " Celcius";
      }
      catch (Exception e)
      {
         txt = "Error: " + e.getMessage();
      }
      showOutput(txt);
   }

   public void showTime(String time)
   {
      labelTimer.setText(time);
   }

   public void showOutput(String txt)
   {
      labelOutput.setText(txt);
      textInput.setText("");
   }

}