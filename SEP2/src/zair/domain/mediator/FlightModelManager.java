package zair.domain.mediator;

import java.util.Observable;

import zair.domain.model.Customer;
import zair.domain.model.CustomerList;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.FlightList;
import zair.domain.model.Log;
import zair.domain.model.Ticket;

public class FlightModelManager extends Observable implements FlightModel
{
   private FlightList list;
   private CustomerList customerList;
   private FlightListServer server;
   private TargetDatabase databaseConnection;
   
   public FlightModelManager() {
      databaseConnection = new FlightDatabaseAdapter(InitServer.getInstance().getDriver(), InitServer.getInstance().getUrl(), InitServer.getInstance().getUser(), InitServer.getInstance().getPw());
      FlightList flightList = new FlightList();
      for (int i = 0; i < databaseConnection.getAllFlights().length; i++)
      {
         flightList.addFlight(databaseConnection.getAllFlights()[i]);
      }
      list = flightList;
      CustomerList customerList = new CustomerList();
      for (int i = 0; i < databaseConnection.getAllCustomers().length; i++)
      {
         customerList.addCustomer(databaseConnection.getAllCustomers()[i]);
      }
      list = flightList;
      this.customerList = customerList;
      server = new FlightListServer(this);
   }
 
   public void addFlight(Flight flight) {
      list.addFlight(flight);
      databaseConnection.addFlight(flight);
      databaseConnection.saveSeats(flight);
      setChanged();
      notifyObservers(Log.getInstance().getTimestamp() + " Flight added " + flight.getId() + ";");
   }
   
   public void removeFlight(Flight flight) {
      String flightId = flight.getId();
      list.removeFlight(flight);
      for (int i = 0; i < customerList.getAllCustomers().length; i++)
      {
         for (int j = 0; j < customerList.getAllCustomers()[i].getTickets().length; j++)
         {
            if (customerList.getAllCustomers()[i].getTickets()[j].getFlight().getId().equals(flightId))
            {
               customerList.getAllCustomers()[i].removeTicket(flightId);
            }
         }
      }
      databaseConnection.removeFlight(flightId);
      setChanged();
      notifyObservers(Log.getInstance().getTimestamp().toString() + " Flight removed " + flightId + ";");
   }
   
   @Override
   public Flight[] getTodayFlights()
   {
      return list.getTodayFlights();
   }

   @Override
   public Flight[] getAllFlights()
   {
      return list.getAllFlights();
   }

   @Override
   public Flight getFlight(int index)
   {
      return list.getFlight(index);
   }

   @Override
   public Flight getFlight(String id)
   {
      return list.getFlight(id);
   }

   @Override
   public Customer getCustomerByCredentials(String username, String password)
   {
      return customerList.getCustomerByCredentials(username, password);
   }

   @Override
   public Customer[] getAllCustomers()
   {
      return customerList.getAllCustomers();
   }

   @Override
   public void addCustomer(Customer customer)
   {
      customerList.addCustomer(customer);
      databaseConnection.addCustomer(customer);
      notifyObservers(Log.getInstance().getTimestamp() + " Customer added " + customer.getId() + ";");
   }

   @Override
   public void bookTicket(String flightID, String customerID, String seatValue, Ticket ticket)
   {
      list.bookTicket(flightID, seatValue);
      customerList.addTicket(customerID, ticket);
      databaseConnection.bookTicket(flightID, customerID, seatValue, ticket);
      notifyObservers(Log.getInstance().getTimestamp() + " Ticket " + ticket.getTicketID() + " booked by Customer " + customerID + ";");
   }

   @Override
   public void cancelTicket(String flightID, String customerID,
         String seatValue, Ticket ticket)
   {
      list.cancelTicket(flightID, seatValue);
      customerList.removeTicket(customerID, flightID);
      databaseConnection.cancelTicket(flightID, customerID, seatValue, ticket);
      notifyObservers(Log.getInstance().getTimestamp() + " Ticket " + ticket.getTicketID() + " canceled by Customer " + customerID + ";");
   }

   @Override
   public Flight[] getFlightByLocationAndDate(String origin, String destination,
         Date departureDate, Date arrivalDate)
   {
      return list.getFlightByLocationAndDate(origin, destination, departureDate, arrivalDate);
   }

   @Override
   public Flight[] getCheapFlights()
   {
      return list.getCheapFlights();
   }

   @Override
   public boolean checkUsername(String username)
   {
      return customerList.checkUsername(username);
   }

   @Override
   public boolean checkAvailabilityCustomer(Customer customer, String flightID)
   {
      return customerList.checkAvailabilityCustomer(customer, flightID);
   }
   
   
}
