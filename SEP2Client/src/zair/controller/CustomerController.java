
package zair.controller;

import java.awt.PageAttributes.OriginType;
import java.util.regex.Pattern;

import zair.domain.mediator.FlightModel;
import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;
import zair.view.CustomerView;

public class CustomerController
{
   private FlightModel model;
   private CustomerView view;
   private int ticketsLeft = 0;
   
   public CustomerController(FlightModel model, CustomerView view)
   {
      this.model = model;
      this.view = view;
      view.switchPanelTo("homePanel");
   }
   
   public void execute(String what)
   {
      switch (what)
      {
         case "bookPanel": 
            if (view.isRowSelected("flightTable"))
            {
               try
               {
               view.switchPanelTo("bookPanel");
               String id = view.getSelectedFlight();
               Flight flight = model.getFlight(id);
               ticketsLeft = flight.getNumberOfTicketsLeft();
               loadSelectedFlight(flight);
               }
               catch (NullPointerException e)
               {
                  view.launchOption("Flight was removed by the administrator. Please press one of the buttons below to reload flights");
               }
            }
            else
            {
               view.launchOption("Please select a flight to book!");
            }
            break;
         case "confirmation":
            if (view.isRowSelected("seatTable") &&  (view.isRowSelected("flightTable")))
            {
               try
               {
               Flight flight = model.getFlight(view.getSelectedFlight());
               String value = view.getValueOf();
               Ticket ticket = new Ticket(value, flight);
               Customer customer = getLoggedInCustomer();
               if (model.checkAvailabilityCustomer(getLoggedInCustomer(), flight.getId()) &&
                     ticketsLeft == model.getFlight(view.getSelectedFlight()).getNumberOfTicketsLeft())
               {
                  model.bookTicket(flight.getId(), customer.getId(), value, ticket);
                  view.launchOption("Successfully booked. Thank you!");
                  loadCustomer(getLoggedInCustomer());
               }
               else if (ticketsLeft != model.getFlight(view.getSelectedFlight()).getNumberOfTicketsLeft())
               {
                  loadSelectedFlight(model.getFlight(view.getSelectedFlight()));
                  view.launchOption("Changes to the flight have been made. Reloading flight.");
               }
               else
               {
                  view.launchOption("You already booked a ticket for this flight!");
               }
               view.switchPanelTo("mainPanel");
               }
               catch (NullPointerException e)
               {
                  view.launchOption("Flight was removed by the administrator!");
                  view.switchPanelTo("mainPanel");
               }
            }
            else
            {
               view.launchOption("Please select a seat.");
            }
         break;  
         case "viewProfile": 
            loadCustomer(getLoggedInCustomer());
            view.switchPanelTo("viewProfilePanel");
         break;
         case "back": view.switchPanelTo("mainPanel");
         break;
         case "logIn": 
         Customer customer = getLoggedInCustomer();
         if (customer == null)
         {
            view.launchOption("Username not found!");
         }
         else if (customer != null)
         {
            loadCustomer(customer);
            view.switchPanelTo("mainPanel");
         }
         break;
         case "signUp": view.switchPanelTo("signUpPanel");
         break;
         case "register":
            if (validationCheck())
            {
               String fname = view.getTextFieldInput("firstName");
               String lname = view.getTextFieldInput("lastName");
               String email = view.getTextFieldInput("email");
               String username = view.getTextFieldInput("usernameField");
               String password = view.getTextFieldInput("passwordField");
               String phone = view.getTextFieldInput("phone");
               String passportNo = view.getTextFieldInput("passportNo");
               if (model.checkUsername(username))
               {
                  Customer cust = new Customer(fname, lname, email, phone,
                        passportNo, username, password);
                  model.addCustomer(cust);
                  view.launchOption("Successfully added!");
                  view.switchPanelTo("homePanel");
               }
               else if (model.checkUsername(username) == false)
               {
                  view.launchOption(
                        "Username is already used by another customer!");
               }
            }
         break;
         case "signOut": view.switchPanelTo("homePanel");
         break;
         case "search": 
            if (!view.getDates("dateDeparture").equals("error")
                  && !view.getDates("dateArrival").equals("error"))
            {
               String origin = view.getComboBoxItem("Origin");
               String destination = view.getComboBoxItem("Destination");
               String[] parts = view.getDates("dateDeparture").split("/");
               String[] parts1 = view.getDates("dateArrival").split("/");
               Date departureDate = new Date(Integer.parseInt(parts[0]),
                     Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
               Date arrivalDate = new Date(Integer.parseInt(parts1[0]),
                     Integer.parseInt(parts1[1]), Integer.parseInt(parts1[2]));
               if (model.getFlightByLocationAndDate(origin, destination,
                     departureDate, arrivalDate) == null)
               {
                  view.launchOption("No flights!");
               }
               else if (model.getFlightByLocationAndDate(origin, destination, departureDate, arrivalDate) != null)
               {
                  loadFlights(model.getFlightByLocationAndDate(origin, destination, departureDate, arrivalDate));
               }
            }
            else if (view.getDates("dateDeparture").equals("error")
                  || view.getDates("dateArrival").equals("error")
                  || (view.getDates("dateDeparture").equals("error")
                        && view.getDates("dateArrival").equals("error")))
            {
               view.launchOption("Please use the date choosers to select the date!");
            }
            break;
         case "today": 
            if (model.getTodayFlights() == null)
            {
               view.launchOption("No flights for today!");
            }
            else if (model.getTodayFlights() != null)
            {
               loadFlights(model.getTodayFlights());
            }
         break;
         case "cheapFlights": 
            if (model.getCheapFlights() == null)
            {
               view.launchOption("No flights!");
            }
            else if (model.getCheapFlights() != null)
            {
               loadFlights(model.getCheapFlights());
            }
         break;
         case "cancelTicket": 
            if (view.isRowSelected("ticketTable"))
            {
               if (view.launchYesNoOption("Are you sure you want to cancel the ticket?").equals("yes"))
               {
                  String[] parts = view.getTicket().split("<");
                  String flightID = parts[0];
                  String seatValue = parts[1];
                  String customerID = getLoggedInCustomer().getId();
                  for (int i = 0; i < getLoggedInCustomer().getTickets().length; i++)
                  {
                     if (getLoggedInCustomer().getTickets()[i].getFlight().getId().equals(flightID))
                     {
                        model.cancelTicket(flightID, customerID, seatValue, getLoggedInCustomer().getTickets()[i]);
                     }
                  }
               }
               loadCustomer(getLoggedInCustomer());
            }
            else
            {
               view.launchOption("Please select a ticket to remove!");
            }
         break;
      }
   }
   
   private void loadCustomer(Customer customer)
   {
      String customerDetails = customer.getName() + "<" + customer.getEmail() + "<" + customer.getPhone() + "<" + customer.getPassportNo();
      String[] tickets = new String[customer.getTickets().length];
      for (int i = 0; i < customer.getTickets().length; i++)
      {
         tickets[i] = customer.getTickets()[i].getFlight().getId() + "<" + customer.getTickets()[i].getTicketID() + "<" + customer.getTickets()[i].getFlight().getOrigin().getLocation() 
               + "<" + customer.getTickets()[i].getFlight().getDestination().getLocation() + "<" + customer.getTickets()[i].getFlight().getDateDeparture()
               + " - " + customer.getTickets()[i].getFlight().getDateArrival() + "<" + customer.getTickets()[i].getFlight().getTimeDeparture()
               + " - " + customer.getTickets()[i].getFlight().getTimeArrival() + "<"
               + customer.getTickets()[i].getSeatNumber();
      }
      view.loadCustomer(customerDetails, tickets);
   }
   
   private void loadFlights(Flight[] flights)
   {
      String[] flight = new String[flights.length];
      for (int i = 0; i < flights.length; i++)
      {
         flight[i] = flights[i].getId() + "<" + flights[i].getOrigin().getLocation() + "<" + flights[i].getDestination().getLocation() + "<" + flights[i].getDateDeparture() + " - "
               + flights[i].getDateArrival() + "<" + flights[i].getTimeDeparture() + " - " + flights[i].getTimeArrival() + "<" + flights[i].getPrice();
      }
      
      view.loadFlights(flight);
   }
   
   private void loadSelectedFlight(Flight flight)
   {
      String flightDetails = flight.getId() + "<" + flight.getDateDeparture() + "<" + flight.getDateArrival()
      + "<" + flight.getTimeDeparture() + "<" + flight.getTimeArrival() + "<" + flight.getOrigin().getLocation()
      + "<" + flight.getDestination().getLocation();
      String[] seats = new String[flight.getAvailableSeats().size()];
      for (int i = 0; i < flight.getAvailableSeats().size(); i++)
      {
         seats[i] = flight.getAvailableSeats().get(i).getSeatValue();
      }
      view.loadSpecificFlight(flightDetails, seats);
   }
   
   private Customer getLoggedInCustomer()
   {
      String username = view.getTextFieldInput("username");
      String password = view.getTextFieldInput("password");
      return model.getCustomerByCredentials(username, password);
   }

   private boolean validationCheck() {
      
      Pattern p = Pattern.compile( "[0-9]" );
       boolean check = false;
       
         check =true;
          String errorMessage = "";//"\n \n";
          
         if ( (view.getTextFieldInput("firstName").isEmpty()) || ( Pattern.compile( "[0-9]" ).matcher( view.getTextFieldInput("firstName") ).find() ) )
          {
             check = false;
             errorMessage = (errorMessage + "\n Incorrect first name");
          }
          
          if (view.getTextFieldInput("lastName").isEmpty())
          {
             check=false;
             errorMessage = (errorMessage + "\n Incorrect last name");
          }
          
         int count = view.getTextFieldInput("email").length() - view.getTextFieldInput("email").replace("@", "").length();
         if( (view.getTextFieldInput("email").isEmpty() ) || !(view.getTextFieldInput("email").contains("@")  ) || count>1)
          {
             check = false;
             errorMessage = (errorMessage + "\n Incorrect email");
          }
          
          
         if ( (view.getTextFieldInput("phone").isEmpty() )   ||  !( Pattern.compile( "[0-9]" ).matcher( view.getTextFieldInput("phone") ).find() )    )
          {
     
             check = false;
             errorMessage = (errorMessage + "\n Incorrect phone");
          }
          
          
          if (view.getTextFieldInput("usernameField").isEmpty())
          {
             check=false;
             errorMessage = (errorMessage + "\n Incorrect username");
          }
          
          if (view.getTextFieldInput("passwordField").length() <4 )
          {
             check=false;
             errorMessage = (errorMessage + "\n Incorrect password (too short)");
          }
          
          if (view.getTextFieldInput("passportNo").isEmpty())
          {
             check=false;
             errorMessage = (errorMessage + "\n Incorrect passportNo (is empty)");
          }
       
          if (check==false) 
            {
             view.launchOption(errorMessage+"\n  \n  \n");
             }
      
      
      return check;
   }
}
