package zair.domain.mediator;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import zair.domain.model.Customer;
import zair.domain.model.Date;
import zair.domain.model.Flight;
import zair.domain.model.Ticket;

public class FlightListClient implements FlightModel {

	private RemoteFlightList list;

	public FlightListClient(String host, int port) throws IOException, NotBoundException {
	  list = (RemoteFlightList) Naming.lookup("rmi://" + host + ":" + port + "/Flight");
	}


	@Override
	public Flight[] getTodayFlights() {
		try
      {
         return list.getTodayFlights();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
		return null;
	}

	@Override
	public Flight[] getAllFlights() {
		try
      {
         return list.getAllFlights();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
		return null;
	}


   @Override
   public Flight getFlight(int index)
   {
      try
      {
         return list.getFlight(index);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }


   @Override
   public Customer getCustomerByCredentials(String username, String password)
   {
      try
      {
         return list.getCustomerBy(username, password);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }


   @Override
   public Customer[] getAllCustomers()
   {
      try
      {
         return list.getAllCustomers();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }


   @Override
   public void addCustomer(Customer customer)
   {
      try
      {
         list.addCustomer(customer);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }


   @Override
   public void bookTicket(String flightID, String customerID, String seatValue, Ticket ticket)
   {
      try
      {
         list.bookTicket(flightID, customerID, seatValue, ticket);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }


   @Override
   public void cancelTicket(String flightID, String customerID,
         String seatValue, Ticket ticket)
   {
      try
      {
         list.cancelTicket(flightID, customerID, seatValue, ticket);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }


   @Override
   public Flight getFlight(String id)
   {
      try
      {
         return list.getFlight(id);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }


   @Override
   public Flight[] getFlightByLocationAndDate(String origin, String destination,
         Date departureDate, Date arrivalDate)
   {
      try
      {
         return list.getFlightByLocationAndDate(origin, destination, departureDate, arrivalDate);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }


   @Override
   public Flight[] getCheapFlights()
   {
      try
      {
         return list.getCheapFlights();
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }


   @Override
   public boolean checkUsername(String username)
   {
      try
      {
         return list.checkUsername(username);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return false;
   }


   @Override
   public boolean checkAvailabilityCustomer(Customer customer, String flightID)
   {
      try
      {
         return list.checkAvailabilityCustomer(customer, flightID);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return false;
   }

}
