package zair.controller;

import java.util.Observable;
import zair.domain.mediator.FlightModel;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.view.FlightView;

public class FlightController
{
   private FlightModel model;
   private FlightView view;
   
   public FlightController(FlightModel model, FlightView view)
   {
      this.model = model;
      this.view = view;
      Observable obs = (Observable) this.model;
      obs.addObserver(view);
      view.showText("Registry created!");
      view.showText("Server started!");
      reloadFlights(model.getAllFlights());
   }
   
   public void execute(String what)
   {
      switch (what)
      {
         case "add": 
            view.switchPanelTo("add-flight");
            break;
         case "save flight":
            if (!view.getComboBoxItem("origin").equals(view.getComboBoxItem("destination")) && !view.getTextFieldInput("price").equals(""))
            {
               String validity = verifyDates(view.getDates("departure_date"), view.getDates("arrival_date"), view.getComboBoxItem("departure"), view.getComboBoxItem("arrival"));
               if (validity.equals(""))
               {
                  String[] parts = view.getDates("departure_date").split("/");
                  String[] parts1 = view.getDates("arrival_date").split("/");
                  Date departureDate = new Date(Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                  Date arrivalDate = new Date(Integer.parseInt(parts1[0]),
                        Integer.parseInt(parts1[1]), Integer.parseInt(parts1[2]));
                  Flight flight = new Flight(departureDate, arrivalDate,
                        view.getComboBoxItem("origin"), view.getComboBoxItem("destination"),
                        view.getComboBoxItem("departure"), view.getComboBoxItem("arrival"),
                        Double.parseDouble(view.getTextFieldInput("price")));
                  if (model.getFlight(flight.getId()) != null)
                  {
                     view.launchOption("This flight already exists in the system.");
                  }
                  else if (model.getFlight(flight.getId()) == null)
                  {
                     model.addFlight(flight);
                     view.launchOption("Successfully added");
                     reloadFlights(model.getAllFlights());
                  }
               }
               else
               {
                  view.launchOption(validity);
               }
            }
            else
            {
               view.launchOption("Origin and destination must have different values! Make sure the price field is completed as well.");
            }
            break;
         case "back from add flight":
            view.switchPanelTo("flight-panel");
            break;
         case "status panel":
            view.switchPanelTo("status-panel");
            break;
         case "remove-flight":
            if (view.isRowSelected())
            {
               model.removeFlight(model.getFlight(view.getSelectedFlight()));
               view.launchOption("Successfully removed");
               reloadFlights(model.getAllFlights());
            }
            else
            {
               view.launchOption("Please select a flight to delete!");
            }
            break;
         case "exit":
            System.exit(1);
            break;
         case "search flight":
            Flight result = model.getFlight(view.getTextFieldInput("searchTextField"));
            if (result == null)
            {
               view.launchOption("No flight with the id has been found!");
            }
            else
            {
               Flight[] array = new Flight[1];
               array[0] = result;
               reloadFlights(array);
            }
            break;
         case "reset view":
            reloadFlights(model.getAllFlights());
            break;
      }
   }
   
   private void reloadFlights(Flight[] flightList)
   {
            String[] flights = new String[flightList.length];
            for (int i = 0; i < flights.length; i++)
            {
               flights[i] = flightList[i].getId() + "<" + flightList[i].getOrigin().getLocation() + "<" + flightList[i].getDestination().getLocation()
                     + "<" + flightList[i].getDateDeparture() + " - " + flightList[i].getDateArrival() 
                     + "<" + flightList[i].getTimeDeparture() + " - " + flightList[i].getTimeArrival()
                     + "<" + flightList[i].getPrice() + "<" + flightList[i].getNumberOfTicketsLeft();
            }
            view.loadFlights(flights);
   }
   
   private String verifyDates(String date1, String date2, String time1, String time2)
   {
      String output = "";
      if (!(date1.equals("error") && date2.equals("error")))
      {
      String[] dateParts = date1.split("/");
      String[] dateParts1 = date2.split("/");
      Date departureDate = new Date(Integer.parseInt(dateParts[0]),
            Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
      Date arrivalDate = new Date(Integer.parseInt(dateParts1[0]),
            Integer.parseInt(dateParts1[1]), Integer.parseInt(dateParts1[2]));
      String[] departureTime = time1.split(":");
      String[] arrivalTime = time2.split(":");
      String valid = "";
      if (departureDate.equals(arrivalDate))
      {
         if (Integer.parseInt(departureTime[0]) > Integer.parseInt(arrivalTime[0]))
         {
            valid += "Arrival time cannot be before the departure time!";
         }
         else if (Integer.parseInt(departureTime[0]) == Integer.parseInt(arrivalTime[0]))
         {
            valid += "Arrival time cannot have the same value as the departure time!";
         }
      }
      if (arrivalDate.isBefore(departureDate))
      {
         valid += "Arrival date cannot be before the departure date!";
      }
      if (departureDate.isBefore(new Date()))
      {
         valid += "Departure date should not be before today's date!";
      }
      return valid;
      }
      else if (date1.equals("error") || date2.equals("error") || (date1.equals("error") && date2.equals("error"))){
         output = "Please use the date choosers to select the date";
      }
      
      return output;
   }
   
}
