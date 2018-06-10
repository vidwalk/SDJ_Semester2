package zair.domain.mediator;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Observable;

import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public class FlightModelManager extends Observable implements FlightModel
{
	private FlightModel list;
	private static final String HOST = Init.getInstance().getIp();
   private static final int PORT = Init.getInstance().getPort();

	public FlightModelManager() throws IOException {
		try
      {
         list = new FlightListClient(HOST, PORT);
      }
      catch (NotBoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
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
   public Customer[] getAllCustomers()
   {
      // TODO Auto-generated method stub
      return list.getAllCustomers();
   }

   @Override
   public Customer getCustomerByCredentials(String username, String password)
   {
      // TODO Auto-generated method stub
      return list.getCustomerByCredentials(username, password);
   }

   @Override
   public void addCustomer(Customer customer)
   {
      list.addCustomer(customer);
   }

   @Override
   public void bookTicket(String flightID, String customerID, String seatValue,
         Ticket ticket)
   {
      list.bookTicket(flightID, customerID, seatValue, ticket);
   }

   @Override
   public void cancelTicket(String flightID, String customerID,
         String seatValue, Ticket ticket)
   {
      list.cancelTicket(flightID, customerID, seatValue, ticket);
   }

   @Override
   public Flight getFlight(String id)
   {
      return list.getFlight(id);
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
      return list.checkUsername(username);
   }

   @Override
   public boolean checkAvailabilityCustomer(Customer customer, String flightID)
   {
      return checkAvailabilityCustomer(customer, flightID);
   }


}
